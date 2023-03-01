package models;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;

@Value
@NoArgsConstructor(force = true)
public class TestDataModel {
      Integer passwordLenMin;
      Integer passwordLenMax;
      Integer ageMin;
      Integer ageMax;
      Integer loginLenMin;
      Integer loginLenMax;
      ArrayList<String> gender;

      public String getGender(int index) {
            if (gender == null) {
                  throw new NullPointerException("Gender list is null");
            }
            return gender.get(index);
      }
}
