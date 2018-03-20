package com.github.ddddog.springbootLearning.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.ddddog.springbootLearning.entity.Stock;

@Mapper
public interface StockMapper {
	 @Select("SELECT * FROM stock WHERE id = #{id}")
	 Stock findById(@Param("id") String id);
	 @Update("update stock set  number = #{number} WHERE id = #{id}")
	 void save(Stock stock);
}