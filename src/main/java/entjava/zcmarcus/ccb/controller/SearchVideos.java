package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.persistence.GenericDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/searchVideos"}
)
public class SearchVideos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());
        String submitAction = req.getParameter("submit");
        String searchTerm = req.getParameter("searchTerm").replaceAll(" ", "%20");

        YoutubeSearchDao searchDao = new YoutubeSearchDao();
        ArrayList<String> searchResultThumbnailUrls = new ArrayList<>();
        ArrayList<String> searchResultVideoIds = new ArrayList<>();
        if(submitAction!=null) {
            List<ItemsItem> searchItems = searchDao.getSearchData(searchTerm).getItems();
            req.setAttribute("searchItems", searchItems);
            req.setAttribute("searchTerm", req.getParameter("searchTerm"));
        }



        RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
        dispatcher.forward(req, resp);

    }
}
