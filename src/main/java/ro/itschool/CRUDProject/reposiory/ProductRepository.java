package ro.itschool.CRUDProject.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.CRUDProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
