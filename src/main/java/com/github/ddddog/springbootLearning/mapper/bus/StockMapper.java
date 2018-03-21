package com.github.ddddog.springbootLearning.mapper.bus;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.ddddog.springbootLearning.bus.entity.Stock;

import tk.mybatis.mapper.common.Mapper;

public interface StockMapper extends Mapper<Stock> {
	@Select("SELECT * FROM STOCK")
	List<Stock> query (Stock stock);
}