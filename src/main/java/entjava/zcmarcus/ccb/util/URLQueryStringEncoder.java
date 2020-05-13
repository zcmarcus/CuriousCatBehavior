package entjava.zcmarcus.ccb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * The interface Url query string encoder.
 */
public interface URLQueryStringEncoder {


    public static final Logger logger = LogManager.getLogger(URLQueryStringEncoder.class);

    /**
     * Encode string characters to meet proper URL standards.
     *
     * @param queryString the query string
     * @return the string
     */
    default String encodeValue(String queryString) {

        try {
            return URLEncoder.encode(queryString, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("Encountered an unsupported encoding operation: {}", e);
            throw new RuntimeException(e.getCause());
        }

    }

}
