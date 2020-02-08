package com.example.ssadminbackend.stock;

import com.example.ssadminbackend.stock.dto.StockResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class StockController {

    @RequestMapping(method = GET, value = "/stock", produces = APPLICATION_JSON_VALUE)
    public List<StockResponseDTO> getStock() {
        return new ArrayList<StockResponseDTO>() {
            {
                add(new StockResponseDTO((long) 1, "Patin xtreme", 34));
                add(new StockResponseDTO((long) 1, "Patin super xtreme", 2));
                add(new StockResponseDTO((long) 1, "Patin recontra xtreme", 4));
                add(new StockResponseDTO((long) 1, "Patin super recontra xtreme", 5));
            }
        };


    }

}
