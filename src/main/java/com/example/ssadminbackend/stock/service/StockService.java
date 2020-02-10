package com.example.ssadminbackend.stock.service;

import com.example.ssadminbackend.Exeptions.EntityNotFoundExceptionById;
import com.example.ssadminbackend.stock.model.Stock;
import com.example.ssadminbackend.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Stock create(Stock item) {
        return stockRepository.saveAndFlush(item);
    }

    public void delete(long id) throws EntityNotFoundExceptionById {
        if (!stockRepository.existsById(id)) {
            throw new EntityNotFoundExceptionById("Invalid Stock ID was provided");
        }
        stockRepository.deleteById(id);
    }

}
