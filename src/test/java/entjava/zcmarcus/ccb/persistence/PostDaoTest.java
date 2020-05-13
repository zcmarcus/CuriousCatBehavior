package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.Comment;
import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit test suite for the Post DAO.
 */
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
        assertEquals(   22, posts.size());
    }

    @Test
    void findNewestSuccess() {
        List<Post> posts = (List<Post>)postDao.findNewestPostsComments(5);
        assertEquals(   5, posts.size());
        Date newestPostDate = posts.get(0).getCreatedDate();
        Date secondNewestPostDate = posts.get(1).getCreatedDate();
        assert(newestPostDate.before(secondNewestPostDate));
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
        assertEquals(1, posts.size());
    }

    @Test
    void findByUserPostsSuccess() {
        User user = (User)userDao.getById(3);
        List<Post> posts = (List<Post>)postDao.findByPropertyEqual("user", user);
        assertEquals(2, posts.size());
    }

    @Test
    void findByPropertiesEqualSuccess() {
        Map<String, String> propertyMap = new HashMap<>();
        propertyMap.put("title", "My cat paws endlessly at the mirror");
        propertyMap.put("videoUrl", "s9LjibhkPfw");
        List<Post> posts = (List<Post>)postDao.findByPropertiesValuesEqual(propertyMap);
        assertEquals(1, posts.size());
    }

    @Test
    void findByPropertiesLikeSuccess() {
        String searchTerm = "door";
        ArrayList<String> propertyList = new ArrayList<>();
        propertyList.add("title");
        propertyList.add("descriptionBody");
        List<Post> posts = (List<Post>)postDao.findByPropertiesLike(propertyList, searchTerm);
        assertEquals(2, posts.size());
    }

    @Test
    void findPropertyLikeSuccess() {
        List<Post> posts = (List<Post>)postDao.findByPropertyLike("title", "endless");
        assertEquals(2, posts.size());
    }

    @Test
    void findByTag() {
        Tag tag = (Tag)tagDao.getById(3);

//        Post post = (Post)postDao.getById(3);
        assertEquals(3, tag.getTaggedPosts().size());
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
     * Verify successful delete of post and associated comments
     */
    @Test
    void deleteCascadeSuccess() {
        Post postToBeDeleted = (Post) postDao.getById(3);
        assertEquals(postToBeDeleted.getComments().size(), 6);
        postDao.delete(postDao.getById(3));
        assertNull(postDao.getById(3));
        List<Comment> associatedCommentsAfterDelete = commentDao.findByPropertyEqual("post", postToBeDeleted);
        assertEquals(associatedCommentsAfterDelete.size(), 0);

    }


}