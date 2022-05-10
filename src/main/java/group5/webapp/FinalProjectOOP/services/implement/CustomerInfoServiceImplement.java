package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.CustomerInfo;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.CustomerInfoRepository;
import group5.webapp.FinalProjectOOP.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CustomerInfoServiceImplement implements CustomerInfoService {

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Override
    public CustomerInfo findByUser(User user) {
        return customerInfoRepository.findByUser(user);
    }

    @Override
    public void addCustomerInfo(CustomerInfo customerInfo) {
        customerInfoRepository.save(customerInfo);
    }

    @Override
    public CustomerInfo findByEmail(String email) {
        return customerInfoRepository.findByEmail(email);
    }
}
