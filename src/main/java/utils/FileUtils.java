package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private FileUtils(){}

    public static <T> T getObjectFromResourceFile(String fileName, Class<T> clazz) {
        try {
            LoggerUtils.info("Trying to retrieve object from resource file");
            return new ObjectMapper().readValue(getResourceFileAsString(fileName), clazz);
        } catch (IOException e) {
            LoggerUtils.error("Error when retrieving object from resource file");
            throw new UncheckedIOException(e);
        }
    }

    private static String getResourceFileAsString(@NonNull String filePath) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(filePath);
        if (url == null) {
            throw new IllegalArgumentException("Url is null, check the FilePath");
        }
        try {
            LoggerUtils.info("Trying to retrieve resource file as string");
            return Files.readString(Paths.get(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            LoggerUtils.info("Error when retrieving resource file as string");
            throw new RuntimeException(e);
        }
    }
}