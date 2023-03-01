package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor(force = true)
public class PlayerModel {
    private Integer id;

    @Override
    public String toString() {
        return "PlayerModel{" +
                "id=" + id +
                '}';
    }
}
