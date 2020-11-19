package app.servlet;



import app.repository.UserRepository;
import app.entity.User;
import app.utils.AppUtils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        public static UserRepository userRepository = new UserRepository();

        public LoginServlet() {
            super();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            User userAccount = userRepository.findUserById(1);

            if (userAccount == null) {
                String errorMessage = "Invalid username or password";

                request.setAttribute("errorMessage", errorMessage);

                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

                dispatcher.forward(request, response);
                return;
            }

            AppUtils.storeLoginedUser(request.getSession(), userAccount);

            //
            int redirectId = -1;
            try {
                redirectId = Integer.parseInt(request.getParameter("redirectId"));
            } catch (Exception e) {
            }
            String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
            if (requestUri != null) {
                response.sendRedirect(requestUri);
            } else {
                response.sendRedirect(request.getContextPath() + "/myInfo");
            }

        }

    }