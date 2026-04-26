package ru.yandex.praktikum.diplom;

import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.diplom.dto.RegisterResponse;

public abstract class AuthorizedUserBaseTestWithUserResponseData extends BaseTestWithUserResponseData {
    @Getter
    private String accessToken;

    @Before
    public final void createUserBeforeTest() {
        accessToken = userSteps.register(email, password, name)
                .body()
                .as(RegisterResponse.class)
                .getAccessToken();
    }

    @After
    public final void cleanupUserAfterTest() {
        userSteps.delete(accessToken);
    }
}
