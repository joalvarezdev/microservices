package com.joalvarez.productservice.service.generals;

import java.util.List;

public interface IBaseService<DTO> {

	List<DTO> findAll();
	DTO findById(Long id);
	DTO update(DTO dto);
	DTO create(DTO dto);
}
