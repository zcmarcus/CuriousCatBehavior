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

class UserRoleDaoTest {

    GenericDao genericDao;
    UserDao userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(UserRole.class);
        userDao = new UserDao();
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
        List<UserRole> roles = (List<UserRole>)genericDao.findAll();
        assertEquals(0, 0);
        assertEquals(7, roles.size());
    }

    @Test
    void getByIdSuccess() {
        User user = userDao.getById(5);
        UserRole userRole = (UserRole)genericDao.getById(2);
        assertNotNull(userRole);
        assertEquals(user, userRole.getUser());
    }

    @Test
    void findByPropertyEqualSuccess() {
        String propertyName = "roleName";
        String value = "user";
        List<UserRole> userRoles = (List<UserRole>)genericDao.findByPropertyEqual(propertyName, value);
        assertEquals(4, userRoles.size());

    }

    @Test
    void insertSuccess() {
        User user = userDao.getById(3);
        UserRole newUserRole = new UserRole(user, "admin");
        user.addRole(newUserRole);
        int id = genericDao.insert(newUserRole);

        UserRole insertedUserRole = (UserRole)genericDao.getById(id);
        assertEquals(user, newUserRole.getUser());
    }

    @Test
    void saveOrUpdateSuccess() {
        String roleName = "admin";
        UserRole userRoleToUpdate = (UserRole)genericDao.getById(4);
        userRoleToUpdate.setRoleName(roleName);
        genericDao.saveOrUpdate(userRoleToUpdate);
        UserRole retrievedUserRole = (UserRole)genericDao.getById(4);
        assertEquals(roleName, retrievedUserRole.getRoleName());
    }

    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(6));
        assertNull(genericDao.getById(6));
    }
}



