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


            String mail = request.getParameter("userEmailIn");
            User user = null;
            if (mail != null) {
                String password = request.getParameter("passwordIn");
                try{
                    user = userService.loginUser(mail, password);
                }catch (AccountPresenceException e){
                    e.printStackTrace();
                    request.setAttribute("errorMessage", e.getMessage());
                    RequestDispatcher dispatcher //
                            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");

                    dispatcher.forward(request, response);
                    return;
                }
                AppUtils.storeLoginedUser(request.getSession(), user);
            }
            else {
                mail = request.getParameter("userEmailUp");
                String password = request.getParameter("passwordUp");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");


                User userAccount = userRepository.findUserByEmail(mail);
                if (userAccount != null) {
                    String errorMessage = "Account with this email already exists";

                    request.setAttribute("errorMessage", errorMessage);

                    RequestDispatcher dispatcher //
                            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/newLoginView.jsp");
                    dispatcher.forward(request, response);
                }


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
                        user = new Trainee();
                    }
                } else {
                    knownAuthority = KnownAuthority.ROLE_MENTOR;
                    user = new Mentor();
                }


                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMail(mail);
                user.setPassword(password);
                UserAuthority userAuthority = userAuthorityRepository.findUserAuthorityByAuthority(knownAuthority);
                Map<KnownAuthority, UserAuthority> knownAuthorityUserAuthorityMap = new
                        HashMap<>();
                knownAuthorityUserAuthorityMap.put(knownAuthority, userAuthority);
                user.setAuthorities(knownAuthorityUserAuthorityMap);
                userRepository.saveUser(user);
                AppUtils.storeLoginedUser(request.getSession(), user);
            }




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