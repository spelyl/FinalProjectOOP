package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductDetail;

public interface ProductDetailService {
    ProductDetail findByProduct(Product product);
}
