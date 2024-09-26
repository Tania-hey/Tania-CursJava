package ro.itschool.CRUDProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.CRUDProject.dtos.ResponsePayload;
import ro.itschool.CRUDProject.dtos.StockDto;
import ro.itschool.CRUDProject.entity.Stock;
import ro.itschool.CRUDProject.mappers.StockMapper;
import ro.itschool.CRUDProject.service.StockService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StockMapper stockMapper;

    @GetMapping("/getStock")
    public ResponseEntity<List<StockDto>> getAllStock() {
        List<Stock> allStocks = stockService.getAllProducts();
        return ResponseEntity.ok(allStocks.stream()
                .map(stockMapper::toDto)
                .toList());
    }

    @PostMapping("/addStock")
    public ResponseEntity<StockDto> addStock(@RequestBody StockDto stockDto) {
        Stock stock = stockService.addStock(StockMapper.toEntity(stockDto));
        return ResponseEntity.ok(stockMapper.toDto(stock));
    }

    @DeleteMapping("/stock/{stockId}")
    public ResponseEntity<ResponsePayload<String>> deleteStock(@PathVariable Long stockId) {
        stockService.deleteStockById(stockId);
        return new ResponseEntity<>(new ResponsePayload<>(null, "Stock deleted successfully"), HttpStatus.OK);
    }

    @PutMapping("/stock/{stockId}")
    public ResponseEntity<ResponsePayload<StockDto>> updateStock(@PathVariable Long stockId, @RequestBody StockDto stockDto) {
        Stock updatedStock = stockService.updateStock(stockId, stockDto);
        return new ResponseEntity<>(new ResponsePayload<>(stockMapper.toDto(updatedStock), "Stock updated successfully"), HttpStatus.OK);
    }

}
