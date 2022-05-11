package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Address;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.AddresRepository;
import group5.webapp.FinalProjectOOP.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AddressServiceImplement implements AddressService {

    @Autowired
    AddresRepository addresRepository;
    @Override
    public List<Address> findAllByUser(User user) {
        return addresRepository.findAllByUser(user);
    }
}
