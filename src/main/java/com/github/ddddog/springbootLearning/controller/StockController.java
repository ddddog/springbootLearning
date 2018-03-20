package com.github.ddddog.springbootLearning.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ddddog.springbootLearning.config.DruidConfig;
import com.github.ddddog.springbootLearning.entity.Stock;
import com.github.ddddog.springbootLearning.mapper.StockMapper;

@RestController
public class StockController {
	private Logger logger = LoggerFactory.getLogger(StockController.class);
    @Autowired
    StockMapper stockRepository;
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    @Autowired
    RedissonClient redissonClient;
    final static String id = "1";
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
                    logger.info("oooo"+stock.getNumber() + 1);
                } finally {
                    lock.unlock();
                }
            });
        }
    }
    
    @RequestMapping("/log")
    public void addLog() {
    	
    }
}
