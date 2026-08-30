package dev.deployhub.config;

import dev.deployhub.catalog.CatalogApplication;
import dev.deployhub.catalog.CatalogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig {
    @Bean
    WebMvcConfigurer corsConfigurer(@Value("${app.cors.allowed-origins}") String origins) {
        return new WebMvcConfigurer() {
            @Override public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins(origins.split(",")).allowedMethods("GET", "POST");
            }
        };
    }

    @Bean
    CommandLineRunner seedCatalog(CatalogRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new CatalogApplication("PostgreSQL", "Reliable relational database", "Database", "17.2", "PG"),
                    new CatalogApplication("Redis", "In-memory cache and message broker", "Data", "7.4", "RD"),
                    new CatalogApplication("Grafana", "Dashboards and operational analytics", "Observability", "11.5", "GF")
                ));
            }
        };
    }
}

