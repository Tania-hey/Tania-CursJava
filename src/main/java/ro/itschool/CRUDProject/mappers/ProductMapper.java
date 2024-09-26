package ro.itschool.CRUDProject.mappers;

import org.springframework.stereotype.Component;
import ro.itschool.CRUDProject.dtos.ProductDto;
import ro.itschool.CRUDProject.entity.Product;

@Component
public class ProductMapper {
    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());

        return productDto;
    }

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        return product;
    }
}
