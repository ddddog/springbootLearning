package com.github.ddddog.springbootLearning.controller;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.ddddog.springbootLearning.entity.Stock;
import com.github.ddddog.springbootLearning.service.StockService;
import com.github.pagehelper.PageInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/stock")
@RestController
public class StockController {
	private Logger logger = LoggerFactory.getLogger(StockController.class);
    @Autowired
    StockService stockRepository;
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    @Autowired
    RedissonClient redissonClient;
    
    final static Integer id = 1;
    @RequestMapping("/addStock")
    public void addStock() {
        RLock lock = redissonClient.getLock("redisson:lock:stock:" + id);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                lock.lock();
                try {
                    Stock stock = stockRepository.findById(id);
                    stock.setNumber(stock.getNumber() + 1);
                    stockRepository.save(stock);
                } finally {
                    lock.unlock();
                }
            });
        }
    }
    
    
    /** 
     * 测试插入 
     * @return 
     */  
    @RequestMapping("/add")  
    public void add(){  
    	for(int i=0;i<100;i++){
    		Stock stock = new Stock();
    		stock.setNumber((int)(Math.random()*100));
    		this.stockRepository.insert(stock); 
    	}
    }  
    /** 
     * 测试分页插件 
     * @return 
     */  
    @RequestMapping("/queryPage")   
    Flux<Stock> queryPage(){
        return null;
    }  
    /** 
     * 测试事务 
     * @return 
     */  
    @RequestMapping("/testTransational")   
    public void test(){  
        try {  
            this.stockRepository.testTransational();  
        } catch (Exception e) {  
            System.out.println(e.getMessage()); 
        }  
          
    }  
    
    @RequestMapping("/{id}")
    public Mono<ResponseEntity<Stock>> getById(@PathVariable String id){
        return Mono.just(stockRepository.findById(Integer.parseInt(id)))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(404).body(null));
    }
}
