package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.User;
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

@WebServlet(
        urlPatterns = {"/admin/maintenanceSearch"}
)
public class MaintenanceSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());
        String submitAction = req.getParameter("submit");

        GenericDao userDao = new GenericDao(User.class);
        GenericDao postDao = new GenericDao(Post.class);
        List<User> users = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        ArrayList<String> propertiesToSearch = new ArrayList<>();
        if(submitAction!=null) {
            switch (submitAction) {
                case "getUserById":
                    User user = (User)userDao.getById(Integer.parseInt((req.getParameter("userSearchTerm"))));
                    users.add(user);
                    req.setAttribute("users", users);
                    break;
                case "findUsersByAny":
                    propertiesToSearch.add("userName");
                    propertiesToSearch.add("lastName");
                    propertiesToSearch.add("firstName");
                    propertiesToSearch.add("email");

                    req.setAttribute("users", userDao.findByPropertiesLike(propertiesToSearch, req.getParameter("userSearchTerm")));
                    break;
                case "viewAllUsers":
                    req.setAttribute("users", userDao.findAll());
                    break;
                case "getPostById":
                    Post post = (Post)postDao.getById(Integer.parseInt((req.getParameter("postSearchTerm"))));
                    posts.add(post);
                    req.setAttribute("posts", posts);
                    break;
                case "findPostsByAny":
                    propertiesToSearch.add("title");
                    propertiesToSearch.add("descriptionBody");
                    req.setAttribute("posts", postDao.findByPropertiesLike(propertiesToSearch, req.getParameter("postSearchTerm")));
                    break;
                case "viewAllPosts":
                    req.setAttribute("posts", postDao.findAll());
                    break;
            }
        }

        logger.debug(users);
        logger.debug(posts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/maintenance_search_results.jsp");
        dispatcher.forward(req, resp);

    }
}
