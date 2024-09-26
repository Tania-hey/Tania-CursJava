package ro.itschool.CRUDProject.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.CRUDProject.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
