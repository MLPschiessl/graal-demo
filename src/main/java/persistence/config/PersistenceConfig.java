package persistence.config;

import jakarta.persistence.EntityManagerFactory;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceManagedTypes;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import persistence.entity.AuthorEntity;
import persistence.entity.DiaryEntity;
import persistence.entity.DiaryEntryEntity;
import persistence.repository.AuthorRepository;

@Configuration(proxyBeanMethods = false)
@EntityScan(basePackageClasses = AuthorEntity.class)
@EnableJpaRepositories(basePackageClasses = {
    AuthorRepository.class,
    AuthorEntity.class,
})
@EnableTransactionManagement
public class PersistenceConfig {

    @Value("${postgres.schema}")
    private String dbSchema;

    @Value("${postgres.user}")
    private String dbUser;

    @Value("${postgres.secret}")
    private String dbSecret;

    @Value("${postgres.url}")
    private String dbUrl;

    @Value("${postgres.hibernate.operation}")
    private String hibernateOperation;

    @Value("${postgres.hibernate.dialect}")
    private String hibernateDialect;



    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setSchema(dbSchema);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbSecret);
        dataSource.setUrl(dbUrl);
        return dataSource;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setManagedTypes(
            PersistenceManagedTypes.of(
                AuthorEntity.class.getName(),
                DiaryEntity.class.getName(),
                DiaryEntryEntity.class.getName()
            )
        );

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", hibernateOperation);
        jpaProperties.setProperty("hibernate.dialect", hibernateDialect);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
