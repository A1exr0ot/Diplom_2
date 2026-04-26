package ru.yandex.praktikum.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedResponse {
    private Boolean success;
    private String name;
    private OrderDto orderDto;
}
