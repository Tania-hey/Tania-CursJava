package ro.itschool.CRUDProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.itschool.CRUDProject.dtos.StockDto;
import ro.itschool.CRUDProject.entity.Stock;
import ro.itschool.CRUDProject.exceptions.ResourceNotFoundException;
import ro.itschool.CRUDProject.reposiory.StockRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public List<Stock> getAllProducts() {
        return (List<Stock>) stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStockById(Long id) {

        if (!stockRepository.existsById(id)) {
            throw new ResourceNotFoundException("Stock not found for product with  id " + id);
        }

        stockRepository.deleteById(id);
    }

    public Stock updateStock(Long stockId, StockDto stockDto) {

        Stock existingStock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for product with  id " + stockId));

        existingStock.setNameProduct(stockDto.getNameProduct());
        existingStock.setProductStock(stockDto.getProductStock());

        return stockRepository.save(existingStock);
    }
}
