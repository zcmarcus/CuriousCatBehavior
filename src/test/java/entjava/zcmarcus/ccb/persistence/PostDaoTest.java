package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.Comment;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PostDaoTest {

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
        List<Post> posts = (List<Post>)postDao.findAll();
        assertEquals(4, posts.size());
    }

    @Test
    void getByIdSuccess() {
        Post retrievedPost = (Post)postDao.getById(2);
        assertNotNull(retrievedPost);
        assertEquals("Flops down on the floor at my feet and rolls around", retrievedPost.getTitle());
    }

    @Test
    void findPropertyEqualSuccess() {
        List<Post> posts = (List<Post>)postDao.findByPropertyEqual("title", "Meowing endlessly at the door");
        assertEquals(2, posts.size());
    }

    @Test
    void findByPropertiesEqualSuccess() {
        Map<String, String> propertyMap = new HashMap<>();
        propertyMap.put("title", "My cat paws endlessly at the mirror");
        propertyMap.put("videoUrl", "https://www.youtube.com/watch?v=fakeurl2");
        List<Post> posts = (List<Post>)postDao.findByPropertiesEqual(propertyMap);
        assertEquals(1, posts.size());
    }

    @Test
    void findPropertyLikeSuccess() {
        List<Post> posts = (List<Post>)postDao.findByPropertyLike("title", "endless");
        assertEquals(3, posts.size());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(3);

        Post newPost = new Post(user, "Chewing on plastic bags", "https://www.youtube.com/watch?v=fakeurl99","My kitten has started chewing on plastic bags. Should I be worried?");
        newPost.setUser(user);

        user.addPost(newPost);

        int insertedPostId = postDao.insert(newPost);
        assertNotEquals(1, insertedPostId);
        Post insertedPost = (Post)postDao.getById(insertedPostId);
        assertEquals(newPost, insertedPost);
    }

    @Test
    void insertWithTags() {
        User existingUser = (User)userDao.getById(3);
        Post newPost = new Post(existingUser, "Chewing on plastic bags", "https://www.youtube.com/watch?v=fakeurl99","My kitten has started chewing on plastic bags. Should I be worried?");

        newPost.setUser(existingUser);
        existingUser.addPost(newPost);

        Tag firstTag = new Tag("kitten");
        Tag secondTag = new Tag("chewing");

        newPost.addTag(firstTag);
        newPost.addTag(secondTag);

        int insertedPostId = postDao.insert(newPost);

        assertNotEquals(1, insertedPostId);
        Post insertedPost = (Post)postDao.getById(insertedPostId);
        assertEquals(newPost, insertedPost);
        assertEquals(2, insertedPost.getTags().size());
    }

    /**
     * Verify successful update of post
     */
    @Test
    void updateSuccess() {
        String newDescription = "Our kitten starts howling at the front door each night at 8:15 PM and 4:15 AM. What the heck?";
        Post postToUpdate = (Post)postDao.getById(4);
        postToUpdate.setDescriptionBody(newDescription);
        postDao.saveOrUpdate(postToUpdate);
        Post retrievedPost = (Post)postDao.getById(4);
        assertEquals(newDescription, retrievedPost.getDescriptionBody());
        assertEquals(postToUpdate, retrievedPost);
    }

    /**
     * Verify successful delete of post
     */
    @Test
    void deleteSuccess() {
        postDao.delete(postDao.getById(3));
        assertNull(postDao.getById(3));
    }

//    TODO: Test delete of post and check cascade effect on tag/comment.
//          Similarly check delete of user and check cascade effect on posts.
//    @Test
//    void deletePostOnDeleteCascadeSuccess() {

//    }

}