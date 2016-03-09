package fr.treeptik.tp.blog.conf;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = { "fr.treeptik.tp.blog.dao" })
public class DatabaseConfiguration {

	private final static Logger LOGGER = Logger	.getLogger(DatabaseConfiguration.class);

//	@Inject
//	private Environment env;

//	@Value("classpath:fr/treeptik/tp/blog/treeptik_tp_blog.sql")
//	private Resource dataScript;

	@Bean
	public DataSource dataSource() {

		LOGGER.debug("Configuring Datasource");

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// on peut récupérer toutes les propriétés injectées dans le context
		// spring (provenant du fichier config.properties) via une méthode
		// getProperty() de l'objet Environment (on peut utiliser cette façon de
		// récupérer les propriétés partout dans le projet
		dataSource.setUrl("jdbc:mysql://localhost:3306/treeptik_tp_blog");
		dataSource.setUsername("root");
		dataSource.setPassword("54F4DF245FFA");


		return dataSource;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
//		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}

//	private DatabasePopulator databasePopulator() {
//		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.setSqlScriptEncoding("utf-8");
//		populator.addScript(dataScript);
//		return populator;
//	}

	/*
	 * De la même manière, on injecte tous les autres beans de configurations
	 * (entityManagerFactory, transactionManager etc...). On retrouve exactement
	 * les mêmes éléments que dans le fichier de configuration
	 * applicationContext.xml
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("persistenceUnit");
		lcemfb.setDataSource(dataSource());
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setPackagesToScan("fr.treeptik.tp.blog.model");
		lcemfb.afterPropertiesSet();
		return lcemfb.getObject();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jpaVendorAdapter;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTransactionManager;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

}