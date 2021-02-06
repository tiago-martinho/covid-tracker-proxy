package pt.tiago;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class StatsResourceTest {

    @Test
    public void testStatsEndpoint() {
        given()
                .when().get("/stats/history/" + LocalDate.now() + "/portugal")
                .then()
                .statusCode(200);
    }

}