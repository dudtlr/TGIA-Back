package capstone.market.repository;

import capstone.market.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryJpaRepository extends JpaRepository<Category,Long> {



}
