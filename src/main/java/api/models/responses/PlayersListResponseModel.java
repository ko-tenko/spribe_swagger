package api.models.responses;

import lombok.Data;
import java.util.ArrayList;

@Data
public class PlayersListResponseModel {

    public ArrayList<Player> players;

    @Data
    public static class Player {
        private Integer id;
        private String screenName;
        private String gender;
        private Integer age;
    }
}