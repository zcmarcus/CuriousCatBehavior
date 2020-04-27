package entjava.zcmarcus.ccb.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import entjava.zcmarcus.ccb.youtube.ItemsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

//Currently ignoring all tests due to inconsistent nature of Youtube Data API responses
//TODO: remove @Ignored annotations when complete
public class YoutubeSearchTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Ignore
    @Test
    public void getResponseKindSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        String expectedKind = "youtube#searchListResponse";
        assertEquals(expectedKind, dao.getSearchData("howling%20cat").getKind());

    }

    @Ignore
    @Test
    public void getSearchResultsCountSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        assertEquals(12, dao.getSearchData("tiny%20kittens").getItems().size());

    }

    @Ignore
    @Test
    public void getSnippetsThumbnailsMediumUrlsSuccess() throws Exception {
        YoutubeSearchDao dao = new YoutubeSearchDao();
        for(ItemsItem item : dao.getSearchData("cats").getItems()) {
            logger.debug(item.getSnippet().getThumbnails().getMedium().getUrl());
            String mediumThumbnailUrl = item.getSnippet().getThumbnails().getMedium().getUrl();
//            assertThat(mediumThumbnailUrl, CoreMatchers.containsString(".jpg"));
            assertThat(mediumThumbnailUrl, Matchers.anyOf(Matchers.containsString(".jpg"), Matchers.containsString(".png")));
        }

    }
}