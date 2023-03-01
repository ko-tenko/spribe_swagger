import api.ApiPath;
import api.ApiMethods;
import api.ApiEditors;
import api.utils.ParamUtils;
import api.utils.RequestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import models.PlayerModel;
import models.RoleModel;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonParserUtil;
import utils.RandomUtils;

public class SupervisorTest {

    @Test
    public void testSupervisorCanCreateAdmin() throws JsonProcessingException {

//        Response response = RequestUtils
//                .sendGet(ApiMethods.CREATE_PLAYER, ApiPath.SUPERVISOR, ParamUtils
//                        .getParamsToCreatePlayer(RandomUtils.generateLogin(),
//                                RandomUtils.generatePassword(),
//                                RandomUtils.generateScreenName(),
//                                RandomUtils.generateAge(),
//                                ApiEditors.USER,
//                                RandomUtils.generateGender()));
//        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
//        Integer id = JsonParserUtil.jsonToObject(RoleModel.class, response.asString()).getId();
//        System.out.println(id);
        PlayerModel playerModel = new PlayerModel();


        playerModel.setId(54321);
        String a = playerModel.toString();
        System.out.println(a);
        System.out.println(playerModel);


//        Response response1 = RequestUtils.sendPost(ApiMethods.GET_PLAYER_BY_ID, ParamUtils.getParamsToGetPlayer(id.toString()));

    }
}
