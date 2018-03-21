package com.github.ddddog.springbootLearning.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.ddddog.springbootLearning.interceptor.SqlPrintInterceptor;
import com.github.pagehelper.PageHelper;

@Configuration
@AutoConfigureAfter({SpringDataSourceConfig.class})
@EnableTransactionManagement 
public class MyBatisConfig implements EnvironmentAware{
   
    //配置文件
    private Environment env;
    @Autowired
    //默认为配置文件中的数据源
    DataSource dataSource;
    
    //根据数据源创建sqlSessionFactory
    @Bean(name="sqlSessionFactory")
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
        factoryBean.setPlugins(new Interceptor[]{pageHelper,sqlPrintInterceptor()});
        return factoryBean;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    //将要执行的sql进行日志打印(不想拦截，就把这方法注释掉)  
    @Bean
    public SqlPrintInterceptor sqlPrintInterceptor(){  
        return new SqlPrintInterceptor();  
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

	@Override
	public void setEnvironment(Environment arg0) {
		this.env = arg0;
		
	}
}
