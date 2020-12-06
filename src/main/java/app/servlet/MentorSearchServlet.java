package app.servlet;
import app.entity.Mentor;
import app.entity.User;
import app.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mentorSearch")
public class MentorSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserService();
    public MentorSearchServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //List<User>mentors = DataDAO.findAllMentors();
        List<Mentor>mentors = userService.getAllMentors();
        request.setAttribute("mentors", mentors);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mentorSearchView.jsp");


        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
