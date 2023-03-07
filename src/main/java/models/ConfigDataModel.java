package models;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class ConfigDataModel {
    String url;
}