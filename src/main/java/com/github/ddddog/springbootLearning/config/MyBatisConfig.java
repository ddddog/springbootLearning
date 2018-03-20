package com.github.ddddog.springbootLearning.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;

@Configuration
@AutoConfigureAfter({DruidConfig.class})
//扫描dao层，basePackages 为dao层所在路径，支持通配符*，多个以,分隔
@MapperScan(basePackages="com.github.ddddog.springbootLearning.mapper")
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer{
    @Autowired
    //配置文件
    private Environment env;
    @Autowired
    //默认为配置文件中的数据源
    DataSource dataSource;
    
    //根据数据源创建sqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //指定数据源
        factoryBean.setDataSource(dataSource);
        //指定封装类所在包
        factoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        //指定mapper.xml文件所在
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations"));
        factoryBean.setMapperLocations(resource);
        
        //添加分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[]{pageHelper});
        return factoryBean;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
