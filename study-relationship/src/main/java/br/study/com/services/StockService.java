package br.study.com.services;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.study.com.dtos.StockDto;
import br.study.com.models.Stock;
import br.study.com.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public StockDto createStock(StockDto data){
        var stock = new Stock(data.stockId(),data.description());
        repository.save(stock);
        return data;
    }
    
}
