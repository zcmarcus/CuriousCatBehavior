package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * The User Dao.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return All users
     */
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        logger.debug("List of all users: {}", users);
        session.close();

        return users;
    }

    /**
     * Gets user by id.
     *
     * @param id the user id
     * @return the user
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();

        return user;
    }

    /**
     * Gets users by property matching value
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property
     */
    public List<User> findByPropertyEquals(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("Searching for user with {} = {}", propertyName, value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.equal(propertyPath, value)); // get at instance variable that points to our table columns

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    /**
     * Gets users by property containing value
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property
     */
    public List<User> findByProperty(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        logger.debug("Searching for user with {} LIKE {}", propertyName, value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath,"%" + value + "%")); // get at instance variable that points to our table columns

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    /**
     * Insert new user.
     *
     * @param user the user
     * @return the number of rows affected (1 if insert successful, 0 if no user inserted)
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(user);
        transaction.commit();
        return id;
    }


    /**
     * Save or update user.
     *
     * @param user the user
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Delete user.
     *
     * @param user the user
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


}
