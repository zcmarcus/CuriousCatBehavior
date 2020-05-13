package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.entity.UserRole;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.persistence.YoutubeSearchDao;
import entjava.zcmarcus.ccb.util.PropertiesLoader;
import entjava.zcmarcus.ccb.util.URLQueryStringEncoder;
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
 * Servlet for handling the editing of a post.
 */
@WebServlet(
        urlPatterns = {"/editPostAction"}
)
public class EditPostAction extends HttpServlet implements PropertiesLoader {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(this.getClass());

        Properties youtubeProperties = null;
        try {
            youtubeProperties = loadProperties("/youtube.properties");
        } catch (Exception e) {
            logger.error("Encountered an error reading the properties file: {}", e);
        }

        GenericDao postDao = new GenericDao(Post.class);
        int postId = Integer.parseInt(req.getParameter("editId"));
        Post postToUpdate = (Post)postDao.getById(postId);

        YoutubeSearchDao youtubeSearchDao = new YoutubeSearchDao();
        SearchData videoData = youtubeSearchDao.getVideoById(postToUpdate.getVideoUrl());

        req.setAttribute("origin", youtubeProperties.getProperty("player.iframe.origin"));
        req.setAttribute("videoData", videoData);
        req.setAttribute("post", postToUpdate);
        req.setAttribute("postId", postId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editPostForm.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        HttpSession session = req.getSession();

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao tagDao = new GenericDao(Tag.class);

        int userId = (Integer) session.getAttribute("userId");

        int postId = Integer.parseInt(req.getParameter("postId"));
        Post postToUpdate = (Post)postDao.getById(postId);

        // check to see if user clicked "Delete Post"
        if(req.getParameter("submit").equals("Delete Post")) {
            postDao.delete(postToUpdate);
            req.setAttribute("postDeleted", postToUpdate);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/deletePostSuccess.jsp");
            dispatcher.forward(req, resp);

        } else {

            Set<Tag> existingTags = postToUpdate.getTags();
            // delete existing roles before adding role names entered in form in order to prevent possible duplication
            // FIXME: rather than delete tags, UPDATE tags with additional logic to prevent duplication
            for(Tag tag: existingTags) {
                tagDao.delete(tag);
            }

            String newTitle = (String)req.getParameter("title");
            String newDescriptionBody = (String)req.getParameter("descriptionBody");

            String tagsSemicolonDelimited = req.getParameter("tags");
            //split tags by semicolon
            String[] tagStrings = tagsSemicolonDelimited.split(";");

            Set<Tag> newTagsToAdd = new HashSet<>();
//            List<Tag> existingTagsToAdd = new ArrayList<>();
//            Set<Tag> currentPostTags = postToUpdate.getTags();
            // Check database to see if tags entered in form already exist in database
            for (String tagString: tagStrings) {
                String trimmedTagString = tagString.trim();
//                List<Tag> matchingTags = (List<Tag>)tagDao.findByPropertyEqual("tagName", trimmedTagString);
//                if(matchingTags.size() == 0) { // tag is not yet in database. create new tag with tag name
                    Tag newTag = new Tag(trimmedTagString);
                    newTagsToAdd.add(newTag);
//                } else { // tag already in database. add to array list of existing tags that match entered tag name
//                    for(Tag matchingTag: matchingTags) {
//                        existingTagsToAdd.add(matchingTag);
//                    }
//                }
            }

            if(newTagsToAdd.size() > 0) { // if any new tags, add to post
                for (Tag newTag: newTagsToAdd) {
                    postToUpdate.addTag(newTag);
                }

                postToUpdate.setTags(newTagsToAdd);
            }

//            if(existingTagsToAdd.size() > 0) { // if any matching tags found already existing in database, add to new post
//                for (Tag existingTag: existingTagsToAdd) {
//                    if(!currentPostTags.contains(existingTag)) {
//                        postToUpdate.addTag(existingTag);
//                    }
//
//                }
//            }

            // FIXME: test to see if working properly
//            for (Tag currentPostTag: currentPostTags) { // remove tag from current post if tags to be added no longer contains it
//                if(!existingTagsToAdd.contains(currentPostTag)) {
//                    postToUpdate.removeTag(currentPostTag);
//                }
//            }


            postToUpdate.setDescriptionBody(newDescriptionBody);
            postToUpdate.setTitle(newTitle);
            postDao.saveOrUpdate(postToUpdate);

            req.setAttribute("postId", postId);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/editPostSuccess.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
