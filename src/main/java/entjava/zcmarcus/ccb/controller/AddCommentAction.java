package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Comment;
import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.util.URLQueryStringEncoder;
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

/**
 * Servlet for adding user comment to post.
 */
@WebServlet(
        urlPatterns = {"/addCommentAction"}
)
public class AddCommentAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = req.getSession();

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao commentDao = new GenericDao(Comment.class);


        String contentBody = (req.getParameter("contentBody"));
        int postId = Integer.parseInt(req.getParameter("postId"));
        int userId = (Integer) session.getAttribute("userId");
        User user = (User) userDao.getById(userId);
        Post post = (Post) postDao.getById(postId);

        Comment newComment = new Comment(contentBody, post, user);
        post.addComment(newComment);
        user.addComment(newComment);

        commentDao.insert(newComment);

        req.setAttribute("post", post);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewPost.jsp");
        dispatcher.forward(req, resp);
    }
}
