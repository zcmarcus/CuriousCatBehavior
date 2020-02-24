package entjava.zcmarcus.ccb.controller;


import entjava.zcmarcus.ccb.entity.User;
import entjava.zcmarcus.ccb.persistence.GenericDao;
import entjava.zcmarcus.ccb.persistence.UserDao;
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

@WebServlet(
        urlPatterns = {"/admin/searchUser"}
)
public class MaintenanceSearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(this.getClass());
        String submitAction = req.getParameter("submit");

        GenericDao userDao = new GenericDao(User.class);
//        UserDao userDao = new UserDao();

        if(submitAction!=null) {
            switch (submitAction) {
            case "findUser":
                req.setAttribute("users", userDao.findByPropertyEqual(req.getParameter("search-property"), req.getParameter("search-term")));
                logger.error("search property: {}", req.getParameter("search-property"));
                logger.error("search term: {}", req.getParameter("search-term"));
                break;
            case "viewAllUsers":
                    logger.error("hi hi");
                req.setAttribute("users", userDao.findAll());
                break;
            }
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/maintenance_search_results.jsp");
        dispatcher.forward(req, resp);

    }
}
