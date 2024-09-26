package ro.itschool.CRUDProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stock {

    @Id
    private Long id;

    private String nameProduct;

    private Integer productStock;
}
