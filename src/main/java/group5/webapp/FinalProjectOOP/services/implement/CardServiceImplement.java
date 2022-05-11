package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Card;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.CardRepository;
import group5.webapp.FinalProjectOOP.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CardServiceImplement implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Override
    public List<Card> findAllByUser(User user) {
        return cardRepository.findAllByUser(user);
    }
}
