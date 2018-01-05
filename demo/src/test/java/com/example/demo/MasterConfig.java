/*
package com.example.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@MapperScan(basePackages = "com.example.demo.usermapper",
		// markerInterface = BaseMapper.class,
		sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAspectJAutoProxy
public class MasterConfig {

	//读取本地库的数据源
	@Bean(name = "primaryDataSource")
	//代表默认使用的是
	@Primary
	public DruidDataSource primaryDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/rc_platfrom");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("lizhenjuan");
		return druidDataSource;
	}




	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DruidDataSource primaryDataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(primaryDataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean("sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate sqlSessionTemplate =
				new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}

//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setBasePackage("test.tcc.capital.mapper");
//		mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
//		return mapperScannerConfigurer;
//	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource primaryDataSource) {
		DataSourceTransactionManager dataSourceTransactionManager =
				new DataSourceTransactionManager(primaryDataSource);
		return dataSourceTransactionManager;
	}
}
*/
