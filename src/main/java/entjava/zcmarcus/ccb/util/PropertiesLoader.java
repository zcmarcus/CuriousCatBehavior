package entjava.zcmarcus.ccb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * Loads a properties file.
 *
 * @author Eric Knapp
 */
public interface PropertiesLoader{


    public static final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    /**
     * Load properties file.
     *
     * @param propertiesFilePath the properties file path
     * @return the properties file
     * @throws Exception the input/output exception
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (Exception ioException) {
            logger.error("An error occurred while reading the properties file: {}", ioException);
            throw ioException;
        }
        return properties;
    }
}