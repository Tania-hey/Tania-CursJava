package ro.itschool.CRUDProject.dtos;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Long stock;

}
