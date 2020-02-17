package entjava.zcmarcus.persistence;

import entjava.zcmarcus.entity.User;
import entjava.zcmarcus.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        dao = new UserDao();
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
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("kmalone@jazz.com", retrievedUser.getEmail());
    }

    @Test
    void getByUserNameSuccess() {
        User retrievedUser = dao.getByUserName("hcoulson");
        assertNotNull(retrievedUser);
        assertEquals("Coulson", retrievedUser.getLastName());
    }

    @Test
    void getByPropertySuccess() {
        List<User> users = dao.getByProperty("firstName", "an");
        assertEquals(3, users.size());
    }

    @Test
    void insertSuccess() {
        User newUser = new User("gcrant", "gcrant@tds.net", "Crant", "Gary");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("Gary", insertedUser.getFirstName());
    }

    @Test
    void updateSuccess() {
        String newFirstName = "Jon";
        User userToUpdate = dao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(1);
        logger.debug(dao.getById(1));
        assertEquals(newFirstName, retrievedUser.getFirstName());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

}