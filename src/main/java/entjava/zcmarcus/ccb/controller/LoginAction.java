package entjava.zcmarcus.ccb.controller;

import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.UserRole;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A servlet for redirecting user to home page after
 * log in attempt.
 */
@WebServlet(
    urlPatterns = {"/loginAction"}
)
public class LoginAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loggedInUser = req.getRemoteUser();

        GenericDao userRoleDao = new GenericDao(UserRole.class);
        GenericDao userDao = new GenericDao(User.class);


        //TODO: try/catch block in case of no user or no role?
//        List<User> users = (List<User>)userDao.findByPropertyEqual("userName", loggedInUser);
//        Set<UserRole> userRoles = users.get(0).getUserRoles();

//        List<String> roleNames = new ArrayList<String>();
//        for(UserRole role : userRoles) {
//            roleNames.add(role.getRoleName());
//        }

        String userAccessLevel;
        List<String> userRoleNames = new ArrayList<>();
        if(req.isUserInRole("admin")) {
            userRoleNames.add("admin");
        }
        if (req.isUserInRole("user")) {
            userRoleNames.add("user");
        }

        req.setAttribute("userRoleNames", userRoleNames);

        logger.error("Logged user : " + req.getRemoteUser() + " has role of admin: " + req.isUserInRole("admin"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
