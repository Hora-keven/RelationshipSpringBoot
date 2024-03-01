package br.study.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.study.com.dtos.StockDto;
import br.study.com.services.StockService;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {
    
    @Autowired
    private StockService service;

    @PostMapping
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto data){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStock(data));
    }
}
