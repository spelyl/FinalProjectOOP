package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.BillDetail;
import group5.webapp.FinalProjectOOP.models.Product;

import java.util.List;
import java.util.Optional;

public interface BillDetailService {
    Optional<BillDetail> findByProductAndBill(Integer product, Integer bill);
    List<BillDetail> findAllByBill(Bill bill);
    void saveBillDetail(BillDetail billDetail);
}
