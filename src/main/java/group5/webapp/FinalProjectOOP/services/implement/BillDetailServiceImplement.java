package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.BillDetail;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.keys.BillDetailKey;
import group5.webapp.FinalProjectOOP.repositories.BillDetailsRepository;
import group5.webapp.FinalProjectOOP.services.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BillDetailServiceImplement implements BillDetailService {

    @Autowired
    BillDetailsRepository billDetailsRepository;
    @Override
    public Optional<BillDetail> findBillDetailsByProductIdAndBillId(Product productId, Bill billId) {
        return billDetailsRepository.findBillDetailsByProductIdAndBillId(productId, billId);
    }

    @Override
    public List<BillDetail> findAllByBillId(Bill billId) {
        return billDetailsRepository.findAllByBillId(billId);
    }

    @Override
    public void saveBillDetail(BillDetail billDetail) {
        billDetailsRepository.save(billDetail);
    }

    @Override
    public void removeBillDetail(BillDetailKey billDetailKey) {
        billDetailsRepository.deleteById(billDetailKey);
    }

    @Override
    public List<BillDetail> findAll() {
        return billDetailsRepository.findAll();
    }
}
