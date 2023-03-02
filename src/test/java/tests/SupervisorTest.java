package tests;

import api.constants.ApiDomains;
import api.constants.ApiEditors;
import api.constants.ApiPaths;
import api.models.requests.PlayerGetByIdRequestModel;
import api.models.responses.PlayerGetByIdResponseModel;
import api.models.requests.PlayerUpdateRequestModel;
import api.utils.ParamUtils;
import api.utils.RequestUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SerializerUtils;
import utils.RandomUtils;

public class SupervisorTest extends BaseTest {

    @Test
    public void testSomething() {
        Response response = RequestUtils
                .sendGet(ApiDomains.CREATE_PLAYER, ApiPaths.SUPERVISOR, ParamUtils
                        .getParamsToCreatePlayer(RandomUtils.generateLogin(),
                                RandomUtils.generatePassword(),
                                RandomUtils.generateScreenName(),
                                RandomUtils.generateAge(),
                                ApiEditors.USER,
                                RandomUtils.generateGender()));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
        PlayerUpdateRequestModel playerUpdateRequestModel = new PlayerUpdateRequestModel();
        playerUpdateRequestModel.setPassword(null);
        String b = SerializerUtils.ObjectToJson(playerUpdateRequestModel);
        Response response4 = RequestUtils.sendPatch(ApiDomains.UPDATE_PLAYER, ApiEditors.SUPERVISOR, 1311069924, b);
        Assert.assertEquals(response4.statusCode(), HttpStatus.SC_OK, "Status code is not 200");


    }

    @Test
    public void testSupervisorCanCreateAdmin() {

        Response response = RequestUtils
                .sendGet(ApiDomains.CREATE_PLAYER, ApiPaths.SUPERVISOR, ParamUtils
                        .getParamsToCreatePlayer(RandomUtils.generateLogin(),
                                RandomUtils.generatePassword(),
                                RandomUtils.generateScreenName(),
                                RandomUtils.generateAge(),
                                ApiEditors.USER,
                                RandomUtils.generateGender()));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
        Integer id = SerializerUtils.jsonToObject(PlayerGetByIdResponseModel.class, response.asString()).getId();
        PlayerGetByIdRequestModel playerGetByIdRequestModel = new PlayerGetByIdRequestModel();
        playerGetByIdRequestModel.setPlayerId(id);
        String a = SerializerUtils.ObjectToJson(playerGetByIdRequestModel);
        Response response1 = RequestUtils.sendPost(ApiDomains.GET_PLAYER, a);
        Assert.assertEquals(response1.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
        Response response2 = RequestUtils.sendDelete(ApiDomains.DELETE_PLAYER, ApiEditors.SUPERVISOR, a);
        Assert.assertEquals(response2.statusCode(), HttpStatus.SC_NO_CONTENT, "Status code is not 204");
        Response response3 = RequestUtils.sendGet(ApiDomains.EMPTY, ApiDomains.GET_ALL_PLAYERS, ParamUtils.getParamsForAllPlayers());
        Assert.assertEquals(response3.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
        PlayerUpdateRequestModel playerUpdateRequestModel = new PlayerUpdateRequestModel();
        playerUpdateRequestModel.setLogin("a1b2c3");
        String b = SerializerUtils.ObjectToJson(playerUpdateRequestModel);
        Response response4 = RequestUtils.sendPatch(ApiDomains.UPDATE_PLAYER, ApiEditors.SUPERVISOR, id, b);
        System.out.println(response4);

    }
}
