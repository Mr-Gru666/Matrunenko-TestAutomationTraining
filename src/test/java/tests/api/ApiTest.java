package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    @Test
    void getPostShouldReturnCorrectData() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", not(emptyOrNullString()));
    }
}
