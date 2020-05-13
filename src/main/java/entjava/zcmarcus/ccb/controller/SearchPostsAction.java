package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.Post;
import entjava.zcmarcus.ccb.entity.Tag;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.persistence.YoutubeSearchDao;
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
import java.util.Set;

/**
 * Servlet for searching for posts based on search term.
 */
@WebServlet(
        urlPatterns = {"/searchPosts"}
)
public class SearchPostsAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        String searchTerm = req.getParameter("postSearchTerm");

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao tagDao = new GenericDao(Tag.class);



        ArrayList<String> propertyList = new ArrayList<>();
        propertyList.add("title");
        propertyList.add("descriptionBody");
        List<Tag> tags = (List<Tag>)tagDao.findByPropertyLike("tagName", searchTerm);
        List<Post> allMatchingPosts = (List<Post>)postDao.findByPropertiesLike(propertyList, searchTerm);
        for (Tag tag: tags) {
            for (Post post: tag.getTaggedPosts()) {
                if(!allMatchingPosts.contains(post)) {
                    allMatchingPosts.add(post);
                }
            }
        }

        List<Tag> allTags = tagDao.findAll();

        req.setAttribute("matchingPosts", allMatchingPosts);
        req.setAttribute("searchTerm", searchTerm);
        req.setAttribute("allTags", allTags);

        RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
        dispatcher.forward(req, resp);

    }
}
