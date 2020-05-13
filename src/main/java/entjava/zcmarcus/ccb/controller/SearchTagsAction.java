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
import java.util.stream.Collectors;

/**
 * Servlet for searching for posts by tag.
 */
@WebServlet(
        urlPatterns = {"/searchTags"}
)
public class SearchTagsAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());

        String tagName = req.getParameter("tagName");

        GenericDao postDao = new GenericDao(Post.class);
        GenericDao tagDao = new GenericDao(Tag.class);

        List<Tag> tags = (List<Tag>)tagDao.findByPropertyLike("tagName", tagName);
        List<Post> postsMatchingTags = new ArrayList<>();
        for (Tag tag: tags) {
            for (Post post: tag.getTaggedPosts()) {
                postsMatchingTags.add(post);
            }
        }

        int maxTags = 20;

        List<Tag> popularTags = tagDao.findMostRecentlyCreatedDistinct(maxTags);
        List<String> tagNames = new ArrayList<>();
        for(Tag tag: popularTags) {
            tagNames.add(tag.getTagName());
        }
        List<String> distinctTagNames = tagNames.stream()
                .distinct()
                .collect(Collectors.toList());

        req.setAttribute("matchingPosts", postsMatchingTags);
        req.setAttribute("searchTerm", tagName);
        req.setAttribute("distinctTagNames", distinctTagNames);

        RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
        dispatcher.forward(req, resp);

    }
}
