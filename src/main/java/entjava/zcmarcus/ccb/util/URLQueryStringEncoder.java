package entjava.zcmarcus.ccb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public interface URLQueryStringEncoder {

    public static final Logger logger = LogManager.getLogger(URLQueryStringEncoder.class);

    default String encodeValue(String queryString) {

        try {
            return URLEncoder.encode(queryString, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("Encountered an unsupported encoding operation: {}", e);
            throw new RuntimeException(e.getCause());
        }

    }

}
