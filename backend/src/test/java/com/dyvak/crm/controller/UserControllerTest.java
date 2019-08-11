package com.dyvak.springbootvuejs.controller;

import com.dyvak.springbootvuejs.Application;
import com.dyvak.springbootvuejs.domain.User;
import com.dyvak.springbootvuejs.security.UserRole;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void addNewUserAndRetrieveItBack() {
        User dyvakYurii = User.builder()
                .email("dyvakyurii@gmail.com")
                .password("12345")
                .role(UserRole.USER)
                .build();


        Long userId =
                given()
                        .queryParam("email", "dyvakyurii@gmail.com")
                        .queryParam("password", "12345")
                        .when()
                        .post("/api/user")
                        .then()
                        .statusCode(is(HttpStatus.SC_CREATED))
                        .extract()
                        .body().as(Long.class);

        User responseUser =
                given()
                        .pathParam("id", userId)
                        .when()
                        .get("/api/user/{id}")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .assertThat()
                        .extract().as(User.class);

        // Did Dyvak Yurii came back?
        assertThat(responseUser.getEmail(), is("dyvakyurii@gmail.com"));
        assertThat(responseUser.getPassword(), is("12345"));
    }

}
