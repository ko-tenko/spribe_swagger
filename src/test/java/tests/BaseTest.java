package tests;

import io.restassured.RestAssured;
import models.ConfigDataModel;
import org.testng.annotations.BeforeMethod;
import utils.FileUtils;

public class BaseTest {

    @BeforeMethod
    public static void setUpBaseUrl() {
        RestAssured.baseURI = FileUtils.getObjectFromResourceFile("config.json", ConfigDataModel.class).getUrl();
    }
}