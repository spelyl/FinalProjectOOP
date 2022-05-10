package group5.webapp.FinalProjectOOP.repositories;

import group5.webapp.FinalProjectOOP.models.Category;
import group5.webapp.FinalProjectOOP.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Slice<Product> findAllByCategory(Category category, Pageable pageable);
    List<Product> findAllByCategory(Category category);

    List<Product> findAllByNameContains(String text, Pageable pageable);

    List<Product> findAllByNameContains(String text);

    List<Product> findTop8ByNameIsNotNull();

    List<Product> findTop4ByNameIsNotNull(Sort sort);

    List<Product> findTop4ByCategoryAndIdIsNotLike(Category category, Integer id);
}
