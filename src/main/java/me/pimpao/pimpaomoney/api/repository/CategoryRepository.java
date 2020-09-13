package me.pimpao.pimpaomoney.api.repository;

import me.pimpao.pimpaomoney.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
