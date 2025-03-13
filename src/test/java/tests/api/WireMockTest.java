package tests.api;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.traineProject.mockserver.WireMockServerRule;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(WireMockServerRule.class)
public class WireMockTest {

    @BeforeEach
    void setupStub() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/test"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"Hello from WireMock!\"}")));
    }


    @Test
    void testMockedApiResponse() {
        RestAssured.baseURI = "http://localhost:8090";

        Response response = given()
                .when()
                .get("/api/test")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello from WireMock!"))
                .extract().response();

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("Hello from WireMock!", response.jsonPath().getString("message"));
    }
}
