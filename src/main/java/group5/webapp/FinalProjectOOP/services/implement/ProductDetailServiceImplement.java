package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductDetail;
import group5.webapp.FinalProjectOOP.repositories.ProductDetailRepository;
import group5.webapp.FinalProjectOOP.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProductDetailServiceImplement implements ProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetail findByProduct(Product product) {
        return productDetailRepository.findByProduct(product);
    }
}
