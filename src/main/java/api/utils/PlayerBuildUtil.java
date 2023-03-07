package api.utils;

import api.models.requests.PlayerUpdateRequestModel;
import utils.RandomUtils;

public class PlayerBuildUtil {

    public static PlayerUpdateRequestModel createPlayer () {
        PlayerUpdateRequestModel player = new PlayerUpdateRequestModel();
        player.setLogin(RandomUtils.generateLogin());
        player.setPassword(RandomUtils.generatePassword());
        player.setScreenName(RandomUtils.generateScreenName());
        player.setAge(RandomUtils.generateAge());
        player.setRole(RandomUtils.generateRole());
        player.setGender(RandomUtils.generateGender());
        return player;
    }
}