package com.sangaha.sangahacamera.common.config.database;

import com.zaxxer.hikari.HikariDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "sangahaCameraEntityManagerFactory",
    transactionManagerRef = "sangahaCameraTransactionManager",
    basePackages = {
        "com.sangaha.sangahacamera.app.**.repository"
    }
)
public class SangahaCameraDataManagerConfig {

    @Autowired
    private DatasourceJpaProperties datasourceJpaProperties;

    @Bean("sangahaCameraDataSource")
    @ConfigurationProperties(prefix = "db.datasource.sangahacamera")
    public DataSource sangahaCameraDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean sangahaCameraEntityManagerFactory(@Qualifier("sangahaCameraDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setPackagesToScan(
            "com.sangaha.sangahacamera.app.*.model.entity"
        );
        entityManagerFactory.setPersistenceUnitName("sangahaCameraPersistenceUnit");
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaProperties(datasourceJpaProperties.additionalProperties());

        return entityManagerFactory;
    }


    @Bean
    public PlatformTransactionManager sangahaCameraTransactionManager(@Qualifier("sangahaCameraEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor sangahaCameraExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
