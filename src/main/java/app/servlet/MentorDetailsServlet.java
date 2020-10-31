package app.servlet;

import app.bean.SimpleUserInfo;
import app.utils.DataDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MentorDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MentorDetailsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String [] splitedURI = request.getRequestURI().split("/");
        long id = Long.parseLong(splitedURI[splitedURI.length-1]);
        SimpleUserInfo userInfo = DataDAO.findUserById(id);
        request.setAttribute("userInfo", userInfo);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mentorInfoView.jsp");


        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }


}
