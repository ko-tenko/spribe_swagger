package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtils {

    private static final Logger logger = LogManager.getLogger();

    public static void info(String logMessage) {
        logger.info(logMessage);
    }

    public static void warn(String logMessage) {
        logger.warn(logMessage);
    }

    public static void error(String logMessage) {
        logger.error(logMessage);
    }

}