package entjava.zcmarcus.ccb.persistence;

import entjava.zcmarcus.ccb.entity.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all user roles.
     *
     * @return All user roles
     */
    public List<UserRole> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
        Root<UserRole> root = query.from(UserRole.class);
        List<UserRole> userRoles = session.createQuery(query).getResultList();

        logger.debug("List of all user roles: {}", userRoles);
        session.close();

        return userRoles;
    }

    /**
     * Gets user role by id.
     *
     * @param id the user role id
     * @return the user role
     */
    public UserRole getById(int id) {
        Session session = sessionFactory.openSession();
        UserRole userRole = session.get(UserRole.class, id);
        session.close();

        return userRole;
    }

    /**
     * Get user role by property (exact match)
     * sample usage: getByPropertyEqual("roleName", "admin")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of user roles meeting the criteria search
     */
    public List<UserRole> findByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRole> query = builder.createQuery( UserRole.class );
        Root<UserRole> root = query.from( UserRole.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<UserRole> userRoles = session.createQuery( query ).getResultList();

        session.close();
        return userRoles;
    }

    /**
     * Insert new user role.
     *
     * @param userRole the user role
     * @return the number of rows affected (1 if insert successful, 0 if no user role inserted)
     */
    public int insert(UserRole userRole) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(userRole);
        transaction.commit();
        return id;
    }

    /**
     * Save or update user role.
     *
     * @param userRole the user role
     */
    public void saveOrUpdate(UserRole userRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userRole);
        transaction.commit();
        session.close();
    }

    /**
     * Delete user.
     *
     * @param userRole the user role
     */
    public void delete(UserRole userRole) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userRole);
        transaction.commit();
        session.close();
    }
}
