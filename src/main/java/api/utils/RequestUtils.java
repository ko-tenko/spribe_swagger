package api.utils;

import io.restassured.response.Response;
import utils.LoggerUtils;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class RequestUtils {

    private RequestUtils(){}

    public static Response sendGet(String apiDomain, String apiPath, HashMap<String, String> params) {
        LoggerUtils.info("Sending GET request");
        return given()
                .spec(RequestSpecUtils.getSpec(apiDomain, apiPath, params))
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response sendPost(String apiDomain, String json) {
        LoggerUtils.info("Sending POST request");
        return given()
                .spec(RequestSpecUtils.postSpec(apiDomain))
                .body(json)
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response sendDelete(String apiDomain, String editor, String json) {
        LoggerUtils.info("Sending DELETE request");
        return given()
                .spec(RequestSpecUtils.deleteSpec(apiDomain, editor))
                .body(json)
                .when()
                .delete()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static Response sendPatch(String apiDomain, String apiEditor, Integer playerId, String json) {
        LoggerUtils.info("Sending PATCH request");
        return given()
                .spec(RequestSpecUtils.patchSpec(apiDomain, apiEditor, playerId))
                .body(json)
                .when()
                .patch()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}