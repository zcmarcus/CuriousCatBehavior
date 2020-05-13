package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.UserRole;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.persistence.YoutubeSearchDao;
import entjava.zcmarcus.ccb.util.PropertiesLoader;
import entjava.zcmarcus.ccb.youtube.SearchData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Servlet for updating or deleting user profile.
 */
@WebServlet(
        urlPatterns = {"/editProfileAction"}
)
public class EditProfileAction extends HttpServlet implements PropertiesLoader {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(this.getClass());


        GenericDao userDao = new GenericDao(User.class);

        int userId = Integer.parseInt(req.getParameter("userId"));
        User userToEdit = (User)userDao.getById(userId);

        req.setAttribute("user", userToEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editProfile.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = req.getSession();

        GenericDao userDao = new GenericDao(User.class);
        GenericDao userRoleDao = new GenericDao(UserRole.class);
        int userId = Integer.parseInt(req.getParameter("userId"));
        User userToUpdate = (User)userDao.getById(userId);
        // check to see if user clicked "Delete Account"
        if(req.getParameter("submit").equals("Delete Account")) { // delete user
            if(!req.isUserInRole("admin")) { // if not an admin deleting, invalidate session
                session.invalidate();
            }
            userDao.delete(userToUpdate);
            req.setAttribute("userDeleted", userToUpdate);
            //FIXME: forward to deleteProfileSuccess
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editProfileSuccess.jsp");
            dispatcher.forward(req, resp);

        } else { // update user

            if (req.getParameterMap().containsKey("roleNames")) { // handle role names if included in form (i.e.: admin is updating user)

                String roleNamesSemicolonDelimited = (String)req.getParameter("roleNames");
                //split roleNames by semicolon
                Set<UserRole> existingUserRoles = userToUpdate.getUserRoles();
                // delete existing roles before adding role names entered in form in order to prevent possible duplication
                // FIXME: rather than delete roles, UPDATE roles with additional logic to prevent duplication
                for(UserRole role: existingUserRoles) {
                    userRoleDao.delete(role);
                }
                Set<UserRole> newUserRoles = new HashSet<UserRole>();
                String[] roleNames = roleNamesSemicolonDelimited.split(";");
                for(String roleName: roleNames) {
                    String trimmedRoleName = roleName.trim();
                    if(trimmedRoleName.length() > 0) { // not an empty string
                        UserRole role = new UserRole(userToUpdate, roleName);
                        newUserRoles.add(role);
                    }

                }
                userToUpdate.setUserRoles(newUserRoles);
            }

            String newFirstName = (String)req.getParameter("firstName");
            String newLastName = (String)req.getParameter("lastName");
            String newEmail = (String)req.getParameter("email");


            userToUpdate.setFirstName(newFirstName);
            userToUpdate.setLastName(newLastName);
            userToUpdate.setEmail(newEmail);
            userDao.saveOrUpdate(userToUpdate);

            req.setAttribute("userId", userId);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/editProfileSuccess.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
