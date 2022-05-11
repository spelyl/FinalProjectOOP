package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.CustomerInfo;
import group5.webapp.FinalProjectOOP.models.User;

import java.util.List;

public interface CustomerInfoService {
    CustomerInfo findByUser(User user);

    void addCustomerInfo(CustomerInfo customerInfo);
    CustomerInfo findByEmail(String email);

    List<CustomerInfo> findAll();
}
