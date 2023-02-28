package api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonParserUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T jsonToClass(Class<T> clazz, String jsonResponse) {
        try {
            return objectMapper.readValue(jsonResponse, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}