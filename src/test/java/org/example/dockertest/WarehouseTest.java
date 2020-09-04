package org.example.dockertest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.configuration.Property;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.equalTo;

public class WarehouseTest {

    private String ownerEntity = """

            {
              "companyName":"Rozetka",
              "lastName": "test3",
              "firstName": "test",
              "contacts": {
                "phones": [
                  {
                    "phone": "55555555532",
                    "typeContact": "Work"
                  }
                ],
                "emails": [
                  {
                    "email": "55555555532",
                    "typeContact": "private"
                  },
                  {
                    "email": "55555555532",
                    "typeContact": "private"
                  }
                ]
              }
            }

            """;

    @Test
    public void canAddOwner() throws InterruptedException {
        sleep(40000);

        given()
                .contentType(ContentType.JSON)
                .body(ownerEntity)
                .log().all()
        .when()
                .post(Property.props.baseUrl()+Property.props.pathAddOwner())

        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("companyName", equalTo("Rozetka"));

    }
}
