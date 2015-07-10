package com.tikal.training.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
@PropertySources({@PropertySource("classpath:application.properties")})
public class BurgersBeanConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//
//        String password = env.getProperty("spring.datasource.password");
//
//
//        if (password != null) {
//            dataSource.setPassword(password);
//        }

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException, SQLException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.tikal.training.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @SuppressWarnings("serial")
    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
                setProperty("hibernate.generate_statistics",env.getProperty("hibernate.generate_statistics"));
            }

        };
    }
}