package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.BillRepository;
import group5.webapp.FinalProjectOOP.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    @Override
    public List<Bill> findAllByDate(String year1, String year2) {
        return billRepository.findAllByDate(year1,year2);
    }

    @Override
    public List<Bill> findAllByUserAndStatus(User user, int status) {
        return billRepository.findAllByUserAndStatus(user, status);
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

}
