package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.Comment;
import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TagDaoTest {

    GenericDao postDao;
    GenericDao userDao;
    GenericDao commentDao;
    GenericDao tagDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        postDao = new GenericDao(Post.class);
        userDao = new GenericDao(User.class);
        commentDao = new GenericDao(Comment.class);
        tagDao = new GenericDao(Tag.class);
        try {
            Database database = Database.getInstance();
            database.runSQL("clean_database.sql");

        } catch (NullPointerException npe) {
            logger.debug("Null point exception: " + npe);

        } catch (Exception e) {
            logger.debug("Encountered a problem: " + e);
        }
    }

    @Test
    void findAllSuccess() {
        List<Tag> tags = (List<Tag>)tagDao.findAll();
        assertEquals(24, tags.size());
    }

    @Test
    void getByIdSuccess() {
        Tag retrievedTag = (Tag)tagDao.getById(2);
        assertNotNull(retrievedTag);
        assertEquals("value-added", retrievedTag.getTagName());
    }

    @Test
    void findPropertyEqualSuccess() {
        String newTagName = "discrete";
        List<Tag> tags = (List<Tag>)tagDao.findByPropertyEqual("tagName", newTagName);
        assertEquals(1, tags.size());
    }

    @Test
    void findByPostSuccess() {
        Post post = (Post)postDao.getById(3);
        logger.debug(post.getTags());
        Set<Tag> tags = post.getTags();
        assertEquals(4, tags.size());
    }

    @Test
    void findPropertyLikeSuccess() {
        List<Tag> tags = (List<Tag>)tagDao.findByPropertyLike("tagName", "is");
        assertEquals(2, tags.size());
    }

    /**
     * Verify successful delete of tag
     */
    @Test
    void deleteSuccess() {
        tagDao.delete(tagDao.getById(24));
        assertNull(tagDao.getById(24));
    }


}