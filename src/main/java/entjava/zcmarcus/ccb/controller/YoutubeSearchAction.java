package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.persistence.YoutubeSearchDao;
import entjava.zcmarcus.ccb.youtube.ItemsItem;
import entjava.zcmarcus.ccb.youtube.SearchData;
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

/**
 * Servlet for searching YouTube for a video with which to use in the creation of a new post.
 */
@WebServlet(
        urlPatterns = {"/youtubeSearchAction"}
)
public class YoutubeSearchAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());
//        String submitAction = req.getParameter("submit");


        String searchTerm = req.getParameter("searchTerm").replaceAll(" ", "%20");


        // ensure that search results contain cat-related results
        if(!searchTerm.contains("cat") && !searchTerm.contains("kitten")) {
            searchTerm = searchTerm + "%20cat";
        }

        String pageToken = req.getParameter("pageToken");

        YoutubeSearchDao searchDao = new YoutubeSearchDao();
        // FIXME: delete two unused vars
//        ArrayList<String> searchResultThumbnailUrls = new ArrayList<>();
//        ArrayList<String> searchResultVideoIds = new ArrayList<>();
        SearchData searchData = null;
//        if(submitAction!=null) {
            if(pageToken != null) {
                searchData = searchDao.getSearchDataWithPage(searchTerm, pageToken);
            } else {
                searchData = searchDao.getSearchData(searchTerm);

            }
            req.setAttribute("searchData", searchData);
            req.setAttribute("searchTerm", req.getParameter("searchTerm"));
//        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/youtubeSearch.jsp");
        dispatcher.forward(req, resp);

    }
}
