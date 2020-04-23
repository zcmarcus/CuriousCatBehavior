package entjava.zcmarcus.ccb.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entjava.zcmarcus.ccb.util.PropertiesLoader;
import entjava.zcmarcus.ccb.youtube.SearchData;
import entjava.zcmarcus.ccb.youtube.Snippet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

public class YoutubeSearchDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private Properties youtubeProperties;
    private Properties googleSecretsProperties;


    /**
     * Instantiates a new Youtube search dao.
     */
    public YoutubeSearchDao() {
        try {
            youtubeProperties = loadProperties("/youtube.properties");
            googleSecretsProperties = loadProperties("/google.secrets.properties");

        } catch (IOException io) {
            logger.debug("There was a problem reading the file: " + io);
        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }

    }

    public SearchData getSearchData(String searchTerm) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youtubeProperties.getProperty("dataAPIv3BaseURL")
                        + "&maxResults=12&q=" + searchTerm + "&key="
                        + googleSecretsProperties.getProperty("ccb_api_key"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug("response: " + response);
        ObjectMapper mapper = new ObjectMapper();
        SearchData search = null;
        try {
            search = mapper.readValue(response, SearchData.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
            e.printStackTrace();
        }
        logger.info("search data: " + search);
        return search;
    }

    public SearchData getSearchDataPageToken(String searchTerm, String pageToken ) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youtubeProperties.getProperty("dataAPIv3BaseURL")
                        + "&maxResults=12&pageToken=" + pageToken
                        + "&q=" + searchTerm + "&key="
                        + googleSecretsProperties.getProperty("ccb_api_key"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug("response: " + response);
        ObjectMapper mapper = new ObjectMapper();
        SearchData search = null;
        try {
            search = mapper.readValue(response, SearchData.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
            e.printStackTrace();
        }
        logger.info("search data: " + search);
        return search;
    }

}