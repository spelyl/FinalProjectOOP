package group5.webapp.FinalProjectOOP.services;

import group5.webapp.FinalProjectOOP.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findCategoryById(Integer id);
}
