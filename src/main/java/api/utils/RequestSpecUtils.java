package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.ConfigModel;
import utils.FileUtils;

import java.util.HashMap;

public class RequestSpecUtils {

    static private final ConfigModel config = FileUtils.getObjectFromResourceFile("config.json", ConfigModel.class);
    static private final String baseUrl = config.getUrl();

    public static RequestSpecification postSpec(String apiMethod, String editor, HashMap<String, String> params) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl.concat(apiMethod).concat(editor))
                .setContentType(ContentType.JSON)
                .addQueryParams(params)
                .build();
    }

    public static RequestSpecification getSpec(String apiMethod, String editor, HashMap<String, String> params) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl.concat(apiMethod).concat(editor))
                .setContentType(ContentType.JSON)
                .addQueryParams(params)
                .build();
    }
}