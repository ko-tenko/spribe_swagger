package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.LoggerUtils;

import java.util.HashMap;

public class RequestSpecUtils {

    private RequestSpecUtils(){}

    public static RequestSpecification postSpec(String apiDomain) {
        LoggerUtils.info("Adding specification for POST request");
        return new RequestSpecBuilder()
                .setBasePath(apiDomain)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getSpec(String apiDomain, String apiPath, HashMap<String, String> params) {
        LoggerUtils.info("Adding specification for GET request");
        return new RequestSpecBuilder()
                .setBasePath(apiDomain.concat(apiPath))
                .setContentType(ContentType.JSON)
                .addQueryParams(params)
                .build();
    }

    public static RequestSpecification deleteSpec(String apiDomain, String apiEditor) {
        LoggerUtils.info("Adding specification for DELETE request");
        return new RequestSpecBuilder()
                .setBasePath(apiDomain.concat(apiEditor))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification patchSpec(String apiDomain, String apiEditor, Integer playerId) {
        LoggerUtils.info("Adding specification for PATCH request");
        return new RequestSpecBuilder()
                .setBasePath(apiDomain.concat(apiEditor).concat("/").concat(playerId.toString()))
                .setContentType(ContentType.JSON)
                .build();
    }
}