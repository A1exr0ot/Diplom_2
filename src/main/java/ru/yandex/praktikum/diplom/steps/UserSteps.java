package ru.yandex.praktikum.diplom.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.yandex.praktikum.diplom.ApiEndpoints;
import ru.yandex.praktikum.diplom.dto.UserLoginRequest;
import ru.yandex.praktikum.diplom.dto.RegisterRequest;

public class UserSteps extends BaseSteps {
    @Step("Регистрация")
    public Response register(String email, String password, String name) {
        RegisterRequest requestBody = new RegisterRequest(
                email,
                password,
                name
        );
        return prepareRestSpec()
                .and().body(requestBody)
                .when()
                .post(ApiEndpoints.AUTH_REGISTER);
    }

    @Step("Вход в систему")
    public Response login(String email, String password) {
        UserLoginRequest requestBody = new UserLoginRequest(
                email,
                password
        );
        return prepareRestSpec()
                .and().body(requestBody)
                .when()
                .post(ApiEndpoints.AUTH_LOGIN);
    }

    @Step("Удаление пользователя")
    public Response delete(String token) {
        return prepareRestSpec(token).when().delete(ApiEndpoints.AUTH_USER);
    }
}
