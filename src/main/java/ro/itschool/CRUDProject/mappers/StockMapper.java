package ro.itschool.CRUDProject.mappers;

import org.springframework.stereotype.Component;
import ro.itschool.CRUDProject.dtos.StockDto;
import ro.itschool.CRUDProject.entity.Stock;

@Component
public class StockMapper {
    public StockDto toDto(Stock stock) {
        StockDto stocktDto = new StockDto();
        stocktDto.setId(stock.getId());
        stocktDto.setNameProduct(stock.getNameProduct());
        stocktDto.setProductStock(stock.getProductStock());

        return stocktDto;
    }


    public static Stock toEntity(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setId(stockDto.getId());
        stock.setNameProduct(stockDto.getNameProduct());
        stock.setProductStock(stockDto.getProductStock());
        return stock;
    }
}