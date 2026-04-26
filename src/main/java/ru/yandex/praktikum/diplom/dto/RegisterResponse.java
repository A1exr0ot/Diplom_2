package ru.yandex.praktikum.diplom.dto;

import lombok.Data;

@Data
public class RegisterResponse {
    private Boolean success;
    private UserResponse userResponse;
    private String accessToken;
    private String refreshToken;
}
