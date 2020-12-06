package app.servlet;



import app.entity.Mentor;
import app.entity.Trainee;
import app.entity.UserAuthority;
import app.entity.enums.KnownAuthority;
import app.exeptions.AccountPresenceException;
import app.repository.UserAuthorityRepository;
import app.repository.UserRepository;
import app.entity.User;
import app.service.UserService;
import app.utils.AppUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        public static UserService userService = new UserService();
        public static UserRepository userRepository = new UserRepository();
        public static UserAuthorityRepository userAuthorityRepository = new UserAuthorityRepository();

        public LoginServlet() {
            super();
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");

            dispatcher.forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {


            String firstName = request.getParameter("firstName");
            User user = null;
            String mail;
            String password;
            if (firstName == null) {
                mail = request.getParameter("userEmailIn");
                password = request.getParameter("passwordIn");
                try{
                    user = userService.loginUser(mail, password);
                }catch (AccountPresenceException e){
                    request.setAttribute("errorMessage", e.getMessage());
                    RequestDispatcher dispatcher //
                            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");

                    dispatcher.forward(request, response);
                    return;
                }
            }
            else {
                mail = request.getParameter("userEmailUp");
                password = request.getParameter("passwordUp");
                String lastName = request.getParameter("lastName");
                KnownAuthority knownAuthority = null;
                String role = request.getParameter("checkMentor");
                if (role == null) {
                    role = request.getParameter("checkTrainee");
                    if (role == null) {
                        String errorMessage = "You have to choose your role";
                        System.out.println(errorMessage);
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher
                                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");
                        dispatcher.forward(request, response);

                    } else {
                        knownAuthority = KnownAuthority.ROLE_TRAINEE;
                    }
                } else {
                    knownAuthority = KnownAuthority.ROLE_MENTOR;
                }
                try{
                    System.out.println(firstName);
                    System.out.println(lastName);
                    System.out.println(mail);
                    System.out.println(password);
                user = userService.registerUser(firstName, lastName, mail, password,knownAuthority );}
                catch (AccountPresenceException e){
                    request.setAttribute("errorMessage", e.getMessage());
                    RequestDispatcher dispatcher
                            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");

                    dispatcher.forward(request, response);
                    return;
                }
            }
            AppUtils.storeLoginedUser(request.getSession(), user);


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