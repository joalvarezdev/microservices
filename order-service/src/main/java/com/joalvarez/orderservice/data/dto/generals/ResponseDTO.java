package com.joalvarez.orderservice.data.dto.generals;

import java.util.List;

public record ResponseDTO (int code, String message, List<String> details) implements BaseDTO {}