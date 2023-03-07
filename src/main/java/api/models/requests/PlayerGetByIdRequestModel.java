package api.models.requests;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor(force = true)
public class PlayerGetByIdRequestModel {
    private Integer playerId;
}