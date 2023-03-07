package api.models.responses;

import lombok.Data;

@Data
public class PlayerCreateResponseModel {
    private Integer age;
    private String gender;
    private Integer id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}