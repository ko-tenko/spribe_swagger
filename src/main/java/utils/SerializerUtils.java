package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectWriter;

public class SerializerUtils {

    private SerializerUtils(){}

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T jsonToObject(Class<T> clazz, String jsonResponse) {
        LoggerUtils.info(String
                .format("Creating an instance of the %s from a json file", clazz));
        try {
            return objectMapper.readValue(jsonResponse, clazz);
        } catch (IOException e) {
            LoggerUtils.error(String
                    .format("Error when trying to create an instance of the %s", clazz));
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> jsonToObjectsArray(Class<T[]> clazz, String strJson) {
        try {
            LoggerUtils.info(String
                    .format("Creating a list of the %s instances from a json file", clazz));
            return Arrays.asList(objectMapper.readValue(strJson, clazz));
        } catch (IOException e) {
            LoggerUtils.error(String
                    .format("Error when trying to create a list of instances of the %s", clazz));
            throw new RuntimeException(e);
        }
    }

    public static String ObjectToJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            LoggerUtils.info("Creating a json file from class instance");
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LoggerUtils.error("Error when creating a json file from class instance");
            throw new RuntimeException(e);
        }
    }
}