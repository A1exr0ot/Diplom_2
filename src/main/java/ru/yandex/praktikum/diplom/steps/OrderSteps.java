package ru.yandex.praktikum.diplom.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.praktikum.diplom.ApiEndpoints;
import ru.yandex.praktikum.diplom.dto.OrderCreateRequest;

import java.util.Arrays;

public class OrderSteps extends BaseSteps {
    @Step("Создание заказа без авторизации")
    public Response create(String... ingredients) {
        return create(prepareRestSpec(), ingredients);
    }

    @Step("Создание заказа с авторизацией")
    public Response createAuthorized(String token, String... ingredients) {
        return create(prepareRestSpec(token), ingredients);
    }

    private Response create(RequestSpecification prepareRestSpec, String[] ingredients) {
        return prepareRestSpec
                .body(new OrderCreateRequest(Arrays.asList(ingredients)))
                .post(ApiEndpoints.ORDERS);
    }
}
