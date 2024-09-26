package ro.itschool.CRUDProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.itschool.CRUDProject.dtos.ProductDto;
import ro.itschool.CRUDProject.entity.Product;
import ro.itschool.CRUDProject.exceptions.ResourceNotFoundException;
import ro.itschool.CRUDProject.reposiory.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteInvoiceById(Long id) {

        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Invoice not found with id " + id);
        }

        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductDto productDto) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());

        return productRepository.save(existingProduct);
    }
}
