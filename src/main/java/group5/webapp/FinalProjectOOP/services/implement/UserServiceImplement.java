package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.UserRepository;
import group5.webapp.FinalProjectOOP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUserNameAndPassWord(String username, String password) {

        return userRepository.getUserByUserNameAndPassWord(username, password);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUserByUserNameAndPassWordAndRole(String username, String password, int role) {

        return userRepository.getUserByUserNameAndPassWordAndRole(username, password, role);
    }

}
