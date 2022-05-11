package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.User;

import java.util.Optional;

public interface BillService {
    Optional<Bill> findByUserAndStatus(User user, Integer status);
    void saveBill(Bill bill);
}
