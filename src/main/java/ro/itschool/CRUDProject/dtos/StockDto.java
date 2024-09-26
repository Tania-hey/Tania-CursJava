package ro.itschool.CRUDProject.dtos;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StockDto {

    @Id
    private Long id;

    private String nameProduct;

    private Integer productStock;
}
