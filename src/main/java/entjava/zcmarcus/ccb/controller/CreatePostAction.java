package entjava.zcmarcus.ccb.controller;


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

@WebServlet(
        urlPatterns = {"/createPostAction"}
)
public class CreatePostAction extends HttpServlet implements URLQueryStringEncoder {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String videoUrl = (req.getParameter("videoUrl"));
        String videoTitle = (req.getParameter("videoTitle"));
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
        GenericDao tagDao = new GenericDao(Tag.class);

        int userId = (Integer) session.getAttribute("userId");
        User user = (User) userDao.getById(userId);
        String tagsSemicolonDelimited = req.getParameter("tags");
        //split tags by semicolon
        String[] tagStrings = tagsSemicolonDelimited.split(";");


        Post newPost = new Post(
                user
                ,req.getParameter("title")
                ,req.getParameter("videoUrl")
                ,req.getParameter("descriptionBody")
        );

        newPost.setUser(user);
        user.addPost(newPost);

        List<Tag> newTagsToAdd = new ArrayList<>();
        List<Tag> existingTagsToAdd = new ArrayList<>();
        // Check database to see if tags entered in form already exist in database
        for (String tagString: tagStrings) {
            String trimmedTagString = tagString.trim();
            List<Tag> matchingTags = (List<Tag>)tagDao.findByPropertyEqual("tagName", trimmedTagString);
            if(matchingTags.size() == 0) { // tag is not yet in database. create new tag with tag name
                Tag newTag = new Tag(trimmedTagString);
                newTagsToAdd.add(newTag);
            } else { // tag already in database. add to array list of existing tags that match entered tag name
                for(Tag matchingTag: matchingTags) {
                    existingTagsToAdd.add(matchingTag);
                }
            }
        }

        if(newTagsToAdd.size() > 0) { // if any new tags not already in database exist, add to new post
            for (Tag newTag: newTagsToAdd) {
                newPost.addTag(newTag);
            }
        }

        if(existingTagsToAdd.size() > 0) { // if any matching tags found already existing in database, add to new post
            for (Tag existingTag: existingTagsToAdd) {
                newPost.addTag(existingTag);
            }
        }


        int newPostId = postDao.insert(newPost);
        req.setAttribute("newPostId", newPostId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createPostSuccess.jsp");
        dispatcher.forward(req, resp);

    }
}
