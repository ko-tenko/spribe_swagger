package api.utils;

import java.util.HashMap;
import api.constants.ApiParams;

public class ParamUtils {

    private ParamUtils(){}

    public static HashMap<String, String> getParamsToCreatePlayer(String login,
                                                                  String password,
                                                                  String screenName,
                                                                  Integer age,
                                                                  String role,
                                                                  String gender) {
        HashMap<String, String> playerParams = new HashMap<>();
        playerParams.put(ApiParams.LOGIN, login);
        playerParams.put(ApiParams.PASSWORD, password);
        playerParams.put(ApiParams.SCREEN_NAME, screenName);
        playerParams.put(ApiParams.AGE, age.toString());
        playerParams.put(ApiParams.ROLE, role);
        playerParams.put(ApiParams.GENDER, gender);
        return playerParams;
    }

    public static HashMap <String, String> getParamsForAllPlayers() {
        return new HashMap<>();
    }
}