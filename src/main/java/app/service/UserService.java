package app.service;

import app.entity.User;
import app.exeptions.AccountPresenceException;
import app.repository.UserAuthorityRepository;
import app.repository.UserRepository;

public class UserService {
    public static UserRepository userRepository = new UserRepository();
    public static UserAuthorityRepository userAuthorityRepository = new UserAuthorityRepository();

    public User loginUser(String mail, String password) throws AccountPresenceException {
        User userAccount = userRepository.findUserByEmail(mail);
        if (userAccount != null) {
            String errorMessage = "Account with this email already exists";
            throw new AccountPresenceException(errorMessage, mail);
        }

        return userAccount;
    }
    public User registerUser(String firstName, String lastName,
                                String mail, String password, String role)
                                                            throws AccountPresenceException {
        User userAccount = userRepository.findUserByEmail(mail);
        if (userAccount == null) {
            String errorMessage = "No user with email";
            throw new AccountPresenceException(errorMessage, mail);
        }


        return userAccount;
    }
}
