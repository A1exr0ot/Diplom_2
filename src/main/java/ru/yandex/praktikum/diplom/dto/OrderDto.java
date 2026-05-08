package ru.yandex.praktikum.diplom.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long number;
    private Integer price;
    private List<Ingredient> ingredients;
}
