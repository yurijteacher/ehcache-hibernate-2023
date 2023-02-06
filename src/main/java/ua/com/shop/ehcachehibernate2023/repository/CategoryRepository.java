package ua.com.shop.ehcachehibernate2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.shop.ehcachehibernate2023.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
