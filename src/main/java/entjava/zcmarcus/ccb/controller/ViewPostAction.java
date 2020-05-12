package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
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
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/viewPostAction"}
)
public class ViewPostAction extends HttpServlet implements PropertiesLoader {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        Properties youtubeProperties = null;
        try {
            youtubeProperties = loadProperties("/youtube.properties");
        } catch (Exception e) {
            logger.error("Encountered an error reading the properties file: {}", e);
        }

        int postId = Integer.parseInt(req.getParameter("postId"));


        GenericDao postDao = new GenericDao(Post.class);
        Post post = (Post) postDao.getById(postId);

        req.setAttribute("post", post);
        req.setAttribute("origin", youtubeProperties.getProperty("player.iframe.origin"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewPost.jsp");
        dispatcher.forward(req, resp);

    }
}
