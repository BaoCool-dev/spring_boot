package ltw.vn.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ltw.vn.Entity.Category;

public interface CategoryService {

	void deleteAll();

	void delete(Category entity);

	void deleteById(Long id);

	long count();

	Optional<Category> findById(Long id);

	List<Category> findAllById(Iterable<Long> ids);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> S save(S entity);

	List<Category> findAll(Sort sort);

	Page<Category> findByCategorynameContaining(String name, Pageable pageable);

	List<Category> findByCategorynameContaining(String name);

}
