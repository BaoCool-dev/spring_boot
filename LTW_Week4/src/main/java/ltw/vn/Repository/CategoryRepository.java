package ltw.vn.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ltw.vn.Entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
