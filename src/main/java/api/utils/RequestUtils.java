package api.utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RequestUtils {

    public static Response getRequest(String apiMethod, String editor, HashMap<String, String> params) {
        return given()
                .spec(RequestSpecUtils.getSpec(apiMethod, editor, params))
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

}