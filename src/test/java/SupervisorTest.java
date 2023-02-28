import api.ApiEditors;
import api.ApiMethods;
import api.ApiRoles;
import api.utils.ParamUtils;
import api.utils.RequestUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupervisorTest {

    @Test
    public void testSupervisorCanCreateAdmin() {
        Response response = RequestUtils
                .getRequest(ApiMethods.CREATE_PLAYER, ApiEditors.SUPERVISOR, ParamUtils
                        .getParamsToCreatePlayer(ApiRoles.ADMIN));
        Assert.assertEquals(response.statusCode(), 200, "Status code is not 200");
    }
}
