package entjava.zcmarcus.ccb.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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


/**
 * The YouTube DAO, which issues calls to the YouTube Data API to retrieve search and video data.
 */
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

    /**
     * Gets search data.
     *
     * @param searchTerm the search term
     * @return the search data
     */
    public SearchData getSearchData(String searchTerm) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youtubeProperties.getProperty("dataAPIv3BaseSearchURL")
                        + "&maxResults=12&q=" + searchTerm + "&key="
                        + googleSecretsProperties.getProperty("ccb_api_key"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.debug("response: " + response);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SearchData search = null;
        try {
            search = mapper.readValue(response, SearchData.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
        }
        logger.info("search data: " + search);
        return search;
    }

    /**
     * Gets search data with page.
     *
     * @param searchTerm the search term
     * @param pageToken  the page token
     * @return the search data with page
     */
    public SearchData getSearchDataWithPage(String searchTerm, String pageToken ) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youtubeProperties.getProperty("dataAPIv3BaseSearchURL")
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
        }
        logger.info("search data: " + search);
        return search;
    }

    /**
     * Gets video by id.
     *
     * @param id the id
     * @return the video by id
     */
    public SearchData getVideoById(String id) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youtubeProperties.getProperty("dataAPIv3BaseVideoURL")
                        + "&id=" + id + "&key="
                        + googleSecretsProperties.getProperty("ccb_api_key"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.error("response: " + response);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SearchData idSearch = null;
        try {
            idSearch = mapper.readValue(response, SearchData.class);
        } catch (JsonProcessingException e) {
            logger.error("Encountered a problem processing JSON: {}", e);
        }
        logger.info("search data for video with id {}: {}", id, idSearch);
        return idSearch;
    }

}