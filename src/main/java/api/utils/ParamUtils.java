package api.utils;

import java.util.HashMap;

import api.ApiParamNames;
import utils.RandomUtils;

public class ParamUtils {

    public static HashMap<String, String> getParamsToCreatePlayer(String role) {
        HashMap<String, String> userParams = new HashMap<>();
        userParams.put(ApiParamNames.LOGIN, RandomUtils.generateLogin());
        userParams.put(ApiParamNames.PASSWORD, RandomUtils.generatePassword());
        userParams.put(ApiParamNames.SCREEN_NAME, RandomUtils.generateLogin());
        userParams.put(ApiParamNames.AGE, RandomUtils.generateAge().toString());
        userParams.put(ApiParamNames.ROLE, role);
        userParams.put(ApiParamNames.GENDER, RandomUtils.generateGender());
        return userParams;
    }
}
