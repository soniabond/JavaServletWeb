package app.service;

import app.entity.Mentor;
import app.entity.Trainee;
import app.entity.User;
import app.entity.UserAuthority;
import app.entity.enums.KnownAuthority;
import app.exeptions.AccountPresenceException;
import app.repository.UserAuthorityRepository;
import app.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public static UserRepository userRepository = new UserRepository();
    public static UserAuthorityRepository userAuthorityRepository = new UserAuthorityRepository();

    public User loginUser(String mail, String password) throws AccountPresenceException {
        User userAccount = userRepository.findUserByEmail(mail);
        if (userAccount == null) {
            String errorMessage = "No user with email ";
            throw new AccountPresenceException(errorMessage+mail, mail);
        }
        if(!password.equals(userAccount.getPassword())){
            String errorMessage = "invalid password";
            throw new AccountPresenceException(errorMessage, mail);
        }


        return userAccount;
    }
    public User registerUser(String firstName, String lastName,
                                String mail, String password,  KnownAuthority knownAuthority)
                                                            throws AccountPresenceException {
        User userAccount = userRepository.findUserByEmail(mail);
        if (userAccount != null) {
            String errorMessage = "Account with this email already exists ";
            throw new AccountPresenceException(errorMessage, mail);
        }

        if (knownAuthority == KnownAuthority.ROLE_MENTOR){
            userAccount = new Mentor();
            System.out.println("MENTOR");
        }
        else if (knownAuthority == KnownAuthority.ROLE_TRAINEE){
            System.out.println("Trainee");
            userAccount = new Trainee();
        }
        userAccount.setFirstName(firstName);
        userAccount.setLastName(lastName);
        userAccount.setMail(mail);
        userAccount.setPassword(password);
        UserAuthority userAuthority = userAuthorityRepository.findUserAuthorityByAuthority(knownAuthority);
        Map<KnownAuthority, UserAuthority> knownAuthorityUserAuthorityMap = new
                HashMap<>();
        knownAuthorityUserAuthorityMap.put(knownAuthority, userAuthority);
        userAccount.setAuthorities(knownAuthorityUserAuthorityMap);
        userRepository.saveUser(userAccount);


        return userAccount;
    }

    public List<Mentor> getAllMentors(){
        List<Mentor> mentors = userRepository.findAllMentors();
        return mentors;
    }
}
