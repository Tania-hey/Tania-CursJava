package ro.itschool.CRUDProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.CRUDProject.dtos.ProductDto;
import ro.itschool.CRUDProject.dtos.ResponsePayload;
import ro.itschool.CRUDProject.entity.Product;
import ro.itschool.CRUDProject.mappers.ProductMapper;
import ro.itschool.CRUDProject.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts.stream()
                .map(productMapper::toDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        Product product = productService.addProduct(productMapper.toEntity(productDto));
        return ResponseEntity.ok(productMapper.toDto(product));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePayload<String>> deleteProduct(@PathVariable Long id) {
        productService.deleteInvoiceById(id);
        return new ResponseEntity<>(new ResponsePayload<>(null, "Product deleted successfully"), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponsePayload<ProductDto>> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product updatedProduct = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(new ResponsePayload<>(productMapper.toDto(updatedProduct), "Product updated successfully"), HttpStatus.OK);
    }

}
