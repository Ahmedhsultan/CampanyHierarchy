package com.iti.companyhierarchy;

import com.iti.companyhierarchy.persistence.UnitOfWork;
import com.iti.companyhierarchy.persistence.repository.AdministrativeRepo;
import com.iti.companyhierarchy.persistence.repository.EngineerRepo;
import com.iti.companyhierarchy.persistence.repository.MangerRepo;
import com.iti.companyhierarchy.persistence.repository.TempLaborerRepo;
import com.iti.companyhierarchy.service.BaseService;
import com.iti.companyhierarchy.service.HierarchyService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppConfig {

    //Services Beans
    @Bean
    public HierarchyService getHierarchyService(){
        return new HierarchyService();
    }

    //Repositories Beans
    @Bean
    public UnitOfWork getUnitOfWork(AdministrativeRepo administrativeRepo, EngineerRepo engineerRepo, MangerRepo mangerRepo, TempLaborerRepo tempLaborerRepo){
        return new UnitOfWork(administrativeRepo, engineerRepo, mangerRepo, tempLaborerRepo);
    }
    @Bean
    public AdministrativeRepo getAdministrativeRepo(){
        return new AdministrativeRepo();
    }
    @Bean
    public MangerRepo getMangerRepo(){
        return new MangerRepo();
    }
    @Bean
    public EngineerRepo getEngineerRepo(){
        return new EngineerRepo();
    }
    @Bean
    public TempLaborerRepo getTempLaborerRepo(){
        return new TempLaborerRepo();
    }

    //ORM Beans
    @Bean
    public MysqlDataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("company_hierarchy");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("root");

        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(MysqlDataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.iti.companyhierarchy");
        emf.setJpaVendorAdapter(vendorAdapter);

        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
