package api.utils;

import java.util.HashMap;

import api.ApiParamNames;
import utils.RandomUtils;

public class ParamUtils {

    public static HashMap<String, String> getParamsToCreatePlayer(String login,
                                                                  String password,
                                                                  String screenName,
                                                                  Integer age,
                                                                  String role,
                                                                  String gender) {
        HashMap<String, String> playerParams = new HashMap<>();
        playerParams.put(ApiParamNames.LOGIN, login);
        playerParams.put(ApiParamNames.PASSWORD, password);
        playerParams.put(ApiParamNames.SCREEN_NAME, screenName);
        playerParams.put(ApiParamNames.AGE, age.toString());
        playerParams.put(ApiParamNames.ROLE, role);
        playerParams.put(ApiParamNames.GENDER, gender);
        return playerParams;
    }

    public static HashMap<String, String> getParamsToGetPlayer(String id) {
        HashMap<String, String> playerParams = new HashMap<>();
        playerParams.put("playerId", id);
        return playerParams;
    }

}
