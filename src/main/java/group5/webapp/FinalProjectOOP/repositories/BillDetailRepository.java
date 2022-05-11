package group5.webapp.FinalProjectOOP.repositories;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.BillDetail;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.keys.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailKey> {

    Optional<BillDetail> findBillDetailByProductAndBill(Product product, Bill bill);

    List<BillDetail> findAllByBill(Bill bill);
}
