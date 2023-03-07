package models;

import lombok.NoArgsConstructor;
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
      ArrayList<String> role;

      public String getGender(int index) {
            if (gender == null) {
                  throw new NullPointerException("Genders list is null");
            }
            return gender.get(index);
      }

      public String getRole(int index) {
            if (gender == null) {
                  throw new NullPointerException("Roles list is null");
            }
            return gender.get(index);
      }
}