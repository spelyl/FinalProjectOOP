package group5.webapp.FinalProjectOOP.services.implement;

import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductImage;
import group5.webapp.FinalProjectOOP.repositories.ProductImageRepository;
import group5.webapp.FinalProjectOOP.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ProductImageServiceImplement implements ProductImageService {

    @Autowired
    ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public List<ProductImage> getAllImageOfProduct(Product product) {
        return productImageRepository.findAllByProduct(product);
    }
}
