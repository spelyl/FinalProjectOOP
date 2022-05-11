package group5.webapp.FinalProjectOOP.repositories;

import group5.webapp.FinalProjectOOP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUserNameAndPassWord(String username, String password);

    User getUserByUserName(String username);

}
