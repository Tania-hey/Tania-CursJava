package ro.itschool.CRUDProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class Product {
    @Id
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Long stock;

}
