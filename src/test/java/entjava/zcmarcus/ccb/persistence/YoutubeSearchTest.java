package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.youtube.ItemsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * JUnit test suite for the YoutubeSearch DAO.
 */
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
//            assertThat(mediumThumbnailUrl, CoreMatchers.containsString(".jpg"));
            assertThat(mediumThumbnailUrl, Matchers.anyOf(Matchers.containsString(".jpg"), Matchers.containsString(".png")));
        }

    }
}