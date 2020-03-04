package hh.swd20.nh1900646.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findByName(String name);
}
