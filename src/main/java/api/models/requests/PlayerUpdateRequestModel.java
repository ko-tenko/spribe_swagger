package api.models.requests;

import lombok.Data;

@Data
public class PlayerUpdateRequestModel {
    private Integer age;
    private String gender;
    private String login;
    private String password;
    private String role;
    private String screenName;
}