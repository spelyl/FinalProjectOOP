package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Address;
import group5.webapp.FinalProjectOOP.models.User;

import java.util.List;

public interface AddressService {

    List<Address> findAllByUser(User user);

    List<Address> findAll();

    Address getById(Integer id);

    void deleteAddressById(Integer id);

    void saveAddress(Address address);
}
