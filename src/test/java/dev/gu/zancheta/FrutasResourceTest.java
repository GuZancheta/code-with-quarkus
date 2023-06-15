package dev.gu.zancheta;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;

    @Test
    void testListEndpoint() {
        given().when().get().then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maçã\",\"qtd\":5},{\"id\":2,\"nome\":\"Pera\",\"qtd\":3},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":1}]"));
    }

    @Test
    void testListFrutas() {
        List<Fruta> list = frutasService.list();
        assert(!list.isEmpty());
    }

}