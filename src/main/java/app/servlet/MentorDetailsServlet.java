package app.servlet;

import app.repository.UserRepository;
import app.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MentorDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MentorDetailsServlet() {
        super();
    }
    private static UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String [] splitedURI = request.getRequestURI().split("/");
        int id = Integer.parseInt(splitedURI[splitedURI.length-1]);
        User userInfo = userRepository.findUserById(id);
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
