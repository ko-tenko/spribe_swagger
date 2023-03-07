package api.utils;

import java.util.HashMap;
import api.constants.ApiParams;
import utils.LoggerUtils;
import utils.RandomUtils;

public class ParamUtils {

    private ParamUtils(){}

    public static HashMap<String, String> getParamsToCreatePlayer(String role) {
        LoggerUtils.info("Adding valid parameters to create a player");
        HashMap<String, String> playerParams = new HashMap<>();
        playerParams.put(ApiParams.LOGIN, RandomUtils.generateLogin());
        playerParams.put(ApiParams.PASSWORD, RandomUtils.generatePassword());
        playerParams.put(ApiParams.SCREEN_NAME, RandomUtils.generateScreenName());
        playerParams.put(ApiParams.AGE, RandomUtils.generateAge().toString());
        playerParams.put(ApiParams.ROLE, role);
        playerParams.put(ApiParams.GENDER, RandomUtils.generateGender());
        return playerParams;
    }

    public static HashMap <String, String> getParamsForAllPlayers() {
        LoggerUtils.info("Adding parameters to get all players info");
        return new HashMap<>();
    }
}