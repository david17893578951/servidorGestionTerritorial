package gestionTerritorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages={"gestionTerritorial.model"})
@EnableJpaRepositories(basePackages = "gestionTerritorial.repository")
@ComponentScan(basePackages={"gestionTerritorial.controller", "gestionTerritorial.utilities", "gestionTerritorial.config"})
@EnableTransactionManagement
public class GestionTerritorialWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTerritorialWebApplication.class, args);
	}
}