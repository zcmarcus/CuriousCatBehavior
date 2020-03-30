package entjava.zcmarcus.ccb.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import entjava.zcmarcus.ccb.youtube.ItemsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;



public class YoutubeSearchTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void getResponseKindSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        String expectedKind = "youtube#searchListResponse";
        assertEquals(expectedKind, dao.getSearchData("howling%20cat").getKind());

    }

    @Test
    public void getSearchResultsCountSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        assertEquals(12, dao.getSearchData("tiny%20kittens").getItems().size());

    }

    @Test
    public void getSnippetsThumbnailsMediumUrlsSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        for(ItemsItem item : dao.getSearchData("cats").getItems()) {
            logger.debug(item.getSnippet().getThumbnails().getMedium().getUrl());
            String mediumThumbnailUrl = item.getSnippet().getThumbnails().getMedium().getUrl();
            assertThat(mediumThumbnailUrl, CoreMatchers.containsString(".jpg"));
        }

    }
}