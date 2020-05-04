//package entjava.zcmarcus.ccb.persistence;
//
//import entjava.zcmarcus.ccb.entity.Comment;
//import entjava.zcmarcus.ccb.entity.Post;
//import entjava.zcmarcus.ccb.entity.Tag;
//import entjava.zcmarcus.ccb.entity.User;
//import entjava.zcmarcus.ccb.test.util.Database;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TagDaoTest {
//
//    GenericDao postDao;
//    GenericDao userDao;
//    GenericDao commentDao;
//    GenericDao tagDao;
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @BeforeEach
//    void setUp() {
//        postDao = new GenericDao(Post.class);
//        userDao = new GenericDao(User.class);
//        commentDao = new GenericDao(Comment.class);
//        tagDao = new GenericDao(Tag.class);
//        try {
//            Database database = Database.getInstance();
//            database.runSQL("clean_database.sql");
//
//        } catch (NullPointerException npe) {
//            logger.debug("Null point exception: " + npe);
//
//        } catch (Exception e) {
//            logger.debug("Encountered a problem: " + e);
//        }
//    }
//
//    @Test
//    void findAllSuccess() {
//        List<Comment> comments = (List<Comment>)commentDao.findAll();
//        assertEquals(20, comments.size());
//    }
//
//    @Test
//    void getByIdSuccess() {
//        Comment retrievedComment = (Comment)commentDao.getById(14);
//        assertNotNull(retrievedComment);
//        assertEquals("szawistowski", retrievedComment.getUser().getUserName());
//    }
//
//    @Test
//    void findPropertyEqualSuccess() {
//        String createdDateString = "2020-05-03 04:35:48";
//        Date createdDate = null;
//        try {
//            createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                    .parse(createdDateString);
//        } catch (ParseException e) {
//            logger.error("An error occurred while trying to parse the date: {}", e);
//        }
//        List<Comment> comments = (List<Comment>)commentDao.findByPropertyEqual("createdDate", createdDate);
//        assertEquals(1, comments.size());
//    }
//
//    @Test
//    void findByUserSuccess() {
//        User user = (User)userDao.getById(3);
//        List<Comment> comments = (List<Comment>)commentDao.findByPropertyEqual("user", user);
//        assertEquals(3, comments.size());
//    }
//
//    @Test
//    void findByPropertiesEqualSuccess() {
//        String createdDateString = "2020-05-03 04:35:48";
//        String modifiedDateString = "2020-05-10 05:30:40";
//        Date createdDate = null;
//        Date modifiedDate = null;
//        try {
//            createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                    .parse(createdDateString);
//            modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                    .parse(modifiedDateString);
//        } catch (ParseException e) {
//            logger.error("An error occurred while trying to parse the date: {}", e);
//        }
//        Map<String, Date> propertyMap = new HashMap<>();
//        propertyMap.put("createdDate", createdDate);
//        propertyMap.put("modifiedDate", modifiedDate);
//        List<Comment> comments = (List<Comment>)commentDao.findByPropertiesValuesEqual(propertyMap);
//        assertEquals(1, comments.size());
//    }
//
//    @Test
//    void findPropertyLikeSuccess() {
//        List<Comment> comments = (List<Comment>)commentDao.findByPropertyLike("contentBody", "id");
//        assertEquals(10, comments.size());
//    }
//
//
//    @Test
//    void insertSuccess() {
//        User user = (User)userDao.getById(3);
//        Post post = (Post)postDao.getById(1);
//
//        Comment newComment = new Comment("Nice post!", post, user);
////        newComment.setUser(user);
////        newComment.setPost(post);
//
//        post.addComment(newComment);
//        user.addComment(newComment);
//
//        int insertedCommentId = commentDao.insert(newComment);
//        assertNotEquals(1, insertedCommentId);
//        Comment insertedComment = (Comment)commentDao.getById(insertedCommentId);
//        assertEquals(newComment, insertedComment);
//    }
//
//    /**
//     * Verify successful update of post
//     */
//    @Test
//    void updateSuccess() {
//        String newContentBody = "This is the edited comment body text";
//        Comment commentToUpdate = (Comment)commentDao.getById(4);
//        commentToUpdate.setContentBody(newContentBody);
//        commentDao.saveOrUpdate(commentToUpdate);
//        Comment retrievedComment = (Comment)commentDao.getById(4);
//        assertEquals(newContentBody, retrievedComment.getContentBody());
//        assertEquals(commentToUpdate, retrievedComment);
//    }
//
//    /**
//     * Verify successful delete of post
//     */
//    @Test
//    void deleteSuccess() {
//        commentDao.delete(commentDao.getById(5));
//        assertNull(commentDao.getById(5));
//    }
//
////    TODO: Test delete of post and check cascade effect on tag/comment.
////          Similarly check delete of user and check cascade effect on posts.
////    @Test
////    void deletePostOnDeleteCascadeSuccess() {
//
////    }
//
//}