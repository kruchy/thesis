package pl.edu.agh.kis.kruchy.hibernate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfiguration {

    private final Environment environment;

    @Autowired
    public HibernateConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceUnitName("persistenceUnit");
        factoryBean.setPackagesToScan("pl.edu.agh.kis.kruchy");
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.data.hibernate.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("spring.data.hibernate.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.data.hibernate.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.data.hibernate.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.data.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("spring.data.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.data.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("spring.data.hibernate.format_sql"));
        return properties;
    }

}
