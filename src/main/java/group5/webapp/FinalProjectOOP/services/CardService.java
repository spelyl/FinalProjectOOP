package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Card;
import group5.webapp.FinalProjectOOP.models.User;

import java.util.List;

public interface CardService {
    List<Card> findAllByUser(User user);

    List<Card> findAll();
}
