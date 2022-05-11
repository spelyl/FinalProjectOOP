package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Address;
import group5.webapp.FinalProjectOOP.models.User;

import java.util.List;

public interface AddressService {

    List<Address> findAllByUser(User user);
}
