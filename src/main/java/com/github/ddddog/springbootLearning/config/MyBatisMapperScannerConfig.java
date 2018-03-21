package com.github.ddddog.springbootLearning.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
// 必须在MyBatisConfig注册后再加载MapperScannerConfigurer，否则会报错
@AutoConfigureAfter({MyBatisConfig.class})
public class MyBatisMapperScannerConfig implements EnvironmentAware{	

	private String basePackage;
	
	private String mappers;
	
	private String notEmpty;
	
	private String identity;
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage(basePackage);
		// 初始化扫描器的相关配置，这里我们要创建一个Mapper的父类
		Properties properties = new Properties();
		properties.setProperty("mappers", mappers);
		properties.setProperty("notEmpty", notEmpty);
		properties.setProperty("IDENTITY", identity);

		mapperScannerConfigurer.setProperties(properties);

		return mapperScannerConfigurer;
	}

	@Override
	public void setEnvironment(Environment env) {
		this.basePackage = env.getProperty("mapper.basePackage");
		this.mappers = env.getProperty("mapper.mappers");
		this.notEmpty = env.getProperty("mapper.not-empty");
		this.identity = env.getProperty("mapper.identity");
		
	}

}
