package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.User;

public interface UserService {
    User getUserByUserNameAndPassWord(String username, String password);

    User getUserByUserName(String username);

    void saveUser(User user);

}
