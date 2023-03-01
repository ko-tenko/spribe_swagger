package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonParserUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T jsonToObject(Class<T> clazz, String jsonResponse) {
        try {
            return objectMapper.readValue(jsonResponse, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String ObjectToJson(Class<T> clazz) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString((Object) clazz);
    }
}