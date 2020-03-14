package entjava.zcmarcus.ccb.controller;

import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.UserRole;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@WebServlet (
    urlPatterns = { "/signupAction" }
)
public class SignupAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);

        String plainTextPassword = req.getParameter("password");
        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
        try {
            credentialHandler.setAlgorithm("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            logger.error("Algorithm {} could not be found", "SHA-256");
        }
        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(plainTextPassword);



        User user = new User(
                req.getParameter("username")
                ,hashedPassword
                ,req.getParameter("email")
                ,req.getParameter("last_name")
                ,req.getParameter("first_name")
        );

        int newUserId = userDao.insert(user);


        if (newUserId > 0) {
            // If role other than default "user" set in request, create associated role along with new user
            GenericDao userRoleDao = new GenericDao(UserRole.class);
            UserRole userRole;
            if (req.getParameterMap().containsKey("role_name")) {
                userRole = new UserRole(user, req.getParameter("role_name"));
            } else {
                userRole = new UserRole(user, "user");
            }
            user.addRole(userRole);
            int newUserRoleId = userRoleDao.insert(userRole);
        }

        req.setAttribute("newUserId", newUserId);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}