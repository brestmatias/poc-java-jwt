package com.example.ssadminbackend.stock;

import com.example.ssadminbackend.Exeptions.EntityNotFoundExceptionById;
import com.example.ssadminbackend.stock.dto.StockResponseDTO;
import com.example.ssadminbackend.stock.model.Stock;
import com.example.ssadminbackend.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class StockController {
    private final StockService service;

    @Autowired
    public StockController(StockService stockService) {
        this.service = stockService;
    }

    @RequestMapping(method = GET, value = "/stock", produces = APPLICATION_JSON_VALUE)
    public List<StockResponseDTO> getStock() {
        return service.getAll().stream().map(e -> StockResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @RequestMapping(method = POST, value = "/stock", produces = APPLICATION_JSON_VALUE)
    public StockResponseDTO createStock(@RequestBody final Stock request) {
        return StockResponseDTO.valueOf(service.create(request));

    }

    @RequestMapping(method = PUT, value = "/stock/{stockId}", produces = APPLICATION_JSON_VALUE)
    public StockResponseDTO update(@PathVariable String stockId,
                                   @RequestParam(value = "quantity", required = false) final Integer quantity) {


    }

    @RequestMapping(method = DELETE, value = "/stock/{stockId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String stockId) {
        try {
            service.delete(Long.parseLong(stockId));
        } catch (EntityNotFoundExceptionById m) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(String.format("Stock wit ID %s. DELETED", stockId));
    }

}
