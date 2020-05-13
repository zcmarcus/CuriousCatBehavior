package entjava.zcmarcus.ccb.controller;

import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Home page servlet. Also welcome page servlet - user navigation to webapp root redirects here.
 */
@WebServlet(
        urlPatterns = {"/homeAction", ""}
)
public class HomeAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());



        GenericDao postDao = new GenericDao(Post.class);
        GenericDao tagDao = new GenericDao(Tag.class);

        // Find 'X' number of newest posts sorted by date; Currently set at 50 posts
        int maxResults = 50;
        List<Post> newestPosts = postDao.findNewestPostsComments(maxResults);

        List<Tag> allTags = tagDao.findAll();

        req.setAttribute("newestPosts", newestPosts);
        req.setAttribute("allTags", allTags);
        req.setAttribute("maxResults", maxResults);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);

    }
}
