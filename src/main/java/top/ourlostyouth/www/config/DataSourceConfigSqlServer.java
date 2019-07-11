package top.ourlostyouth.www.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "top.ourlostyouth.www.dao.SqlServerMapper", sqlSessionFactoryRef = "SqlServerSqlSessionFactory")
public class DataSourceConfigSqlServer {
    @Bean(name = "SqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlservers")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "SqlServerSqlSessionFactory")
    public SqlSessionFactory SqlServerSqlSessionFactory(@Qualifier("SqlServerDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath*:top/ourlostyouth/www/dao/SqlServerMapper/mapper/*.xml"));
        //new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/SqlServer/*.xml"));
        return bean.getObject();
    }
    @Bean("SqlServerSqlSessionFactory")
    public SqlSessionTemplate sqlserversqlsessiontemplate(
            @Qualifier("SqlServerSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
