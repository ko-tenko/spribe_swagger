package api.utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.LoggerUtils;

import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RequestUtils {

    public static Response sendGet(String apiMethod, String editor, HashMap<String, String> params) {
        LoggerUtils.info("Sending GET request");
        return given()
                .spec(RequestSpecUtils.getSpec(apiMethod, editor, params))
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    public static Response sendPost(String apiMethod, HashMap<String, String> params) {
        LoggerUtils.info("Sending POST request");
        return given()
                .spec(RequestSpecUtils.postSpec(apiMethod, params))
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    public static Response sendDelete(String apiMethod, String editor, HashMap<String, String> params) {
        LoggerUtils.info("Sending DELETE request");
        return given()
                .spec(RequestSpecUtils.getSpec(apiMethod, editor, params))
                .when()
                .delete()
                .then()
                .extract()
                .response();
    }

    public static Response sendPatch(String apiMethod, String editor, HashMap<String, String> params) {
        LoggerUtils.info("Sending PATCH request");
        return given()
                .spec(RequestSpecUtils.getSpec(apiMethod, editor, params))
                .when()
                .patch()
                .then()
                .extract()
                .response();
    }
}