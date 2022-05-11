package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.User;

import java.util.List;

public interface UserService {
    User getUserByUserNameAndPassWord(String username, String password);

    User getUserByUserName(String username);

    void saveUser(User user);
    User getUserByUserNameAndPassWordAndRole(String username,String password, int role);

    User getUserById(Integer id);

    boolean checkEdiUsername(String username, int id);

    List<User> findAll();

    void deleteUserById(Integer id);

}
