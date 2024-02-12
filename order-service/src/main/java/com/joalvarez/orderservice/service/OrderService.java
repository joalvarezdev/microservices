package com.joalvarez.orderservice.service;

import com.joalvarez.orderservice.constants.ErrorCode;
import com.joalvarez.orderservice.data.dao.OrderDAO;
import com.joalvarez.orderservice.data.dto.ItemRequestInventoryDTO;
import com.joalvarez.orderservice.data.dto.OrderDTO;
import com.joalvarez.orderservice.data.dto.generals.BaseWebClientResponse;
import com.joalvarez.orderservice.data.mapper.OrderMapper;
import com.joalvarez.orderservice.exception.generals.GenericException;
import com.joalvarez.orderservice.exception.generals.NotImplementedException;
import com.joalvarez.orderservice.service.generals.GenericService;
import com.joalvarez.orderservice.service.interfaces.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService extends GenericService<OrderDAO, OrderMapper> implements IOrderService {

	private final WebClient.Builder inventoryClient;

	public OrderService(OrderDAO orderDAO, OrderMapper mapper, WebClient.Builder inventoryClient) {
		super(orderDAO, mapper);
		this.inventoryClient = inventoryClient;
	}

	@Override
	public List<OrderDTO> findAll() {
		return this.dao.findAll().stream()
			.map(this.mapper::toDTO)
			.collect(Collectors.toList());
	}

	@Override
	public OrderDTO findById(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public OrderDTO update(OrderDTO orderDTO) {
		throw new NotImplementedException();
	}

	@Override
	public OrderDTO create(OrderDTO dto) {
		BaseWebClientResponse response = this.inventoryClient.build()
			.post()
			.uri("lb://inventory-service/inventory-service/in-stock")
			.bodyValue(dto.getDetails().stream().map(detail -> new ItemRequestInventoryDTO(detail.getSku(), detail.getQuantity())))
			.retrieve()
			.bodyToMono(BaseWebClientResponse.class)
			.block();

		if (Objects.isNull(response) || response.hasErrors()) {
			throw new GenericException(
				HttpStatus.NOT_FOUND,
				ErrorCode.CLIENT_BAD_REQUEST_ERROR
			);
		}

		if (Objects.isNull(dto.getId())) {
			dto.setId(UUID.randomUUID());
		}

		dto.setNumber(this.dao.countBy() + 1);

		return this.mapper.toDTO(this.dao.save(this.mapper.fromDTO(dto)));
	}
}
