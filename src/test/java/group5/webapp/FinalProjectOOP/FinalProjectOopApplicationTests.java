package group5.webapp.FinalProjectOOP;

import group5.webapp.FinalProjectOOP.models.Category;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductDetail;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.CategoryRepository;
import group5.webapp.FinalProjectOOP.repositories.ProductDetailRepository;
import group5.webapp.FinalProjectOOP.repositories.ProductRepository;
import group5.webapp.FinalProjectOOP.repositories.UserRepository;
import group5.webapp.FinalProjectOOP.services.ProductService;
import group5.webapp.FinalProjectOOP.services.implement.ProductServiceImplement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FinalProjectOopApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;

	@Test
	void contextLoads() {
	}

}
