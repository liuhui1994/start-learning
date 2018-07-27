package org.business.system.activity.configuration;



import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.github.pagehelper.PageHelper;

@Configuration
public class ActivityDataSourcesConfiguration {

	@Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
	@Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());

        bean.setTypeAliasesPackage("org.business.system.activity.model");

        //分页插件设置
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        
//        <!-- 4.0.0以后版本可以不设置该参数 -->
//        <property name="dialect" value="mysql"/>
//        <!-- 该参数默认为false -->
//        <!-- 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用 -->
//        <!-- 和startPage中的pageNum效果一样-->
//        <property name="offsetAsPageNum" value="true"/>
//        <!-- 该参数默认为false -->
//        <!-- 设置为true时，使用RowBounds分页会进行count查询 -->
//        <property name="rowBoundsWithCount" value="true"/>
//        <!-- 设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果 -->
//        <!-- （相当于没有执行分页查询，但是返回结果仍然是Page类型）-->
//        <property name="pageSizeZero" value="true"/>
//        <!-- 3.3.0版本可用 - 分页参数合理化，默认false禁用 -->
//        <!-- 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 -->
//        <!-- 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 -->
//        <property name="reasonable" value="false"/>
//        <!-- 3.5.0版本可用 - 为了支持startPage(Object params)方法 -->
//        <!-- 增加了一个`params`参数来配置参数映射，用于从Map或ServletRequest中取值 -->
//        <!-- 可以配置pageNum,pageSize,count,pageSizeZero,reasonable,orderBy,不配置映射的用默认值 -->
//        <!-- 不理解该含义的前提下，不要随便复制该配置 -->
//        <property name="params" value="pageNum=pageHelperStart;pageSize=pageHelperRows;"/>
//        <!-- 支持通过Mapper接口参数来传递分页参数 -->
//        <property name="supportMethodsArguments" value="false"/>
//        <!-- always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page -->
//        <property name="returnPageInfo" value="none"/>
        
        //设置过后页码从第一页开始
        //添加分页插件
        bean.setPlugins(new Interceptor[]{pageHelper});

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //基于注解扫描Mapper，不需配置xml路径
            bean.setMapperLocations(resolver.getResources("classpath:mybatis/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
