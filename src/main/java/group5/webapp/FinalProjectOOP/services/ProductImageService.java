package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductImage;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> findAll();

    List<ProductImage> getAllImageOfProduct(Product product);
}
