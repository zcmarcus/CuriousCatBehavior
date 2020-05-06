package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/createPostAction"}
)
public class CreatePostAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String videoUrl = req.getParameter("videoUrl");
        String videoTitle = req.getParameter("videoTitle");
        req.setAttribute("videoUrl", videoUrl);
        req.setAttribute("videoTitle", videoTitle);
        req.setAttribute("fullYoutubeUrl", "http://www.youtube.com/watch?v="+videoUrl);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createPostForm.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = req.getSession();

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao userDao = new GenericDao(User.class);

        int userId = (Integer) session.getAttribute("userId");
        User user = (User) userDao.getById(userId);
        String tagsSemicolonDelimited = req.getParameter("tags");
        //split tags by semicolon
        String[] tagStrings = tagsSemicolonDelimited.split(";");


        //TODO: remove whitespace near semicolons??
        List<Tag> tags = new ArrayList<>();
        for (String tagString: tagStrings) {
            Tag newtag = new Tag(tagString);
            tags.add(newtag);
        }

        Post newPost = new Post(
                user
                ,req.getParameter("title")
                ,req.getParameter("videoUrl")
                ,req.getParameter("descriptionBody")
        );
        for (Tag tag: tags) {
            newPost.addTag(tag);
        }

        newPost.setUser(user);
        user.addPost(newPost);

        int newPostId = postDao.insert(newPost);
        logger.debug("New post with Id: {} created", newPostId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createPostSuccess.jsp");
        dispatcher.forward(req, resp);

    }
}
