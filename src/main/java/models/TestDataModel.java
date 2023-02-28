package models;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;

@Value
@NoArgsConstructor(force = true)
public class TestDataModel {
      Integer passwordLenMin;
      Integer passwordLenMax;
      Integer userAgeMin;
      Integer userAgeMax;
      Integer userLoginLenMin;
      Integer userLoginLenMax;
      ArrayList<String> gender;

      public String getGender(int index) {
            return gender.get(index);
      }
}
