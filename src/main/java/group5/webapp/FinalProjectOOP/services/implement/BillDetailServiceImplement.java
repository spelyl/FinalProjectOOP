package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.BillDetail;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.repositories.BillDetailRepository;
import group5.webapp.FinalProjectOOP.repositories.BillRepository;
import group5.webapp.FinalProjectOOP.repositories.ProductRepository;
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
    BillDetailRepository billDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BillRepository billRepository;

    @Override
    public Optional<BillDetail> findByProductAndBill(Integer product, Integer bill) {
        return billDetailRepository.findBillDetailByProductAndBill(productRepository.getById(product),billRepository.getById(bill));
    }

    @Override
    public List<BillDetail> findAllByBill(Bill bill) {
        return billDetailRepository.findAllByBill(bill);
    }

    @Override
    public void saveBillDetail(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }
}
