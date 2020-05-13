package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Comment;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet for handling the editing of a post.
 */
@WebServlet(
        urlPatterns = {"/deleteCommentAction"}
)
public class DeleteCommentAction extends HttpServlet implements PropertiesLoader {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = req.getSession();

        GenericDao commentDao = new GenericDao(Comment.class);

        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comment commentToDelete = (Comment) commentDao.getById(commentId);

        commentDao.delete(commentToDelete);

        req.setAttribute("postId", req.getParameter("postId"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewPostAction");
            dispatcher.forward(req, resp);








    }
}
