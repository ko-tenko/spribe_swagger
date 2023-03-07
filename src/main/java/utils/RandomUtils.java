package utils;

import models.TestDataModel;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomUtils {

    private RandomUtils(){}

    static private final TestDataModel testData = FileUtils
            .getObjectFromResourceFile("testData.json", TestDataModel.class);
    static private final Random random = new Random();

    public static String generatePassword() {
        LoggerUtils.info("Generating password");
        String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(random
                .ints(testData.getPasswordLenMin(), testData.getPasswordLenMax() + 1)
                .findFirst()
                .getAsInt());
        List<Character> pwdChars = randomAlphanumeric.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        return pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static String generateLogin() {
        LoggerUtils.info("Generating login");
        int userLoginLen = random
                .ints(testData.getLoginLenMin(), testData.getLoginLenMax())
                .findFirst()
                .getAsInt();
        StringBuilder randomString = new StringBuilder();
        random.ints(65, 122)
                .filter(i->!(i>90&&i<97))
                .boxed()
                .limit(userLoginLen)
                .map(Character::toChars)
                .forEach(randomString::append);
        return randomString.toString();
    }

    public static String generateScreenName() {
        LoggerUtils.info("Generating screenName");
        return generateLogin();
    }

    public static Integer generateAge() {
        LoggerUtils.info("Generating age");
        return random.ints(testData.getAgeMin(), testData.getAgeMax())
                .findFirst()
                .getAsInt();
    }

    public static String generateGender() {
        LoggerUtils.info("Generating gender");
        return testData.getGender(random.ints(0, 1 + 1)
                .findFirst()
                .getAsInt());
    }

    public static String generateRole() {
        LoggerUtils.info("Generating player's role");
        return testData.getRole(random.ints(0, 2 + 1)
                .findFirst()
                .getAsInt());
    }
}