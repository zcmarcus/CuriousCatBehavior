package entjava.zcmarcus.ccb.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YoutubeSearchTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void getYoutubeSearchResultsSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        String expectedKind = "youtube#searchListResponse";
        assertEquals(expectedKind, dao.getSearchData().getKind());

    }
}