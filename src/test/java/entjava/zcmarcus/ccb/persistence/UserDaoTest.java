package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.UserRole;
import entjava.zcmarcus.ccb.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        logger.error("TESTING");
        genericDao = new GenericDao(User.class);
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
        List<User> users = (List<User>)genericDao.findAll();
        assertEquals(7, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(2);
        assertNotNull(retrievedUser);
        assertEquals("kmalone", retrievedUser.getUserName());
    }

    @Test
    void findPropertyEqualSuccess() {
        List<User> users = (List<User>)genericDao.findByPropertyEqual("userName", "hcoulson");
        assertEquals(1, users.size());
    }

    @Test
    void findByPropertiesEqualSuccess() {
        Map<String, String> propertyMap = new HashMap<>();
        propertyMap.put("firstName", "Hannah");
        propertyMap.put("lastName", "Coulson");
        List<User> users = (List<User>)genericDao.findByPropertiesEqual(propertyMap);
        assertEquals(2, users.size());
    }

    @Test
    void insertSuccess() {
        User newUser = new User("gcrant", "secretpw99", "gcrant@tds.net", "Crant", "Gary");
        int id = genericDao.insert(newUser);
        assertNotEquals(1, id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    @Test
    void insertWithUserRole() {
        User newUser = new User("gcrant", "secretpw99", "gcrant@tds.net", "Crant", "Gary");

        String roleName = "admin";
        UserRole role = new UserRole(newUser, roleName);

        newUser.addRole(role);
        int id = genericDao.insert(newUser);



        assertNotEquals(0, id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getUserRoles().size());
    }

    @Test
    void updateSuccess() {
        String newFirstName = "Jon";
        User userToUpdate = (User)genericDao.getById(1);
        userToUpdate.setFirstName(newFirstName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(1);
        assertEquals(newFirstName, retrievedUser.getFirstName());
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    @Test
    void deleteUserOnDeleteCascadeSuccess() {
        GenericDao userRoleDao = new GenericDao(UserRole.class);
        genericDao.delete(genericDao.getById(6));
        assertNull(genericDao.getById(6));
        assertNull(userRoleDao.getById(1));
    }

}