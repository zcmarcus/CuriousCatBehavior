package entjava.zcmarcus.ccb.controller;

import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
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
import java.util.List;

@WebServlet(
        urlPatterns = {""}
)
public class HomeAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());
        logger.error("HELLO");

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao tagDao = new GenericDao(Tag.class);

        List<Post> allPosts = postDao.findAll();
        List<Tag> allTags = tagDao.findAll();

        req.setAttribute("allPosts", allPosts);
        req.setAttribute("allTags", allTags);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);

    }
}
