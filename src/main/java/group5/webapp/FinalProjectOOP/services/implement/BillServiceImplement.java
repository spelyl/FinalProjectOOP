package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.BillRepository;
import group5.webapp.FinalProjectOOP.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class BillServiceImplement implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public Optional<Bill> findByUserAndStatus(User user, Integer status) {
        return billRepository.findByUserAndStatus(user,status);
    }

    @Override
    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }
}
