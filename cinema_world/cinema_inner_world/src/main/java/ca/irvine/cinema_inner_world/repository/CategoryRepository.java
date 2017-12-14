package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.Category;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer>{
    Optional<Category> findByCategory(String category);
}