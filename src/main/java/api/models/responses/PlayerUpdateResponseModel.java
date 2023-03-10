package api.models.responses;

import lombok.Data;

@Data
public class PlayerUpdateResponseModel {
    private Integer age;
    private String gender;
    private Integer id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}