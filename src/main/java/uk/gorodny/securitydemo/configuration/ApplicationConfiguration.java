package uk.gorodny.securitydemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfiguration {

    /**
     * CORS - дополнительная настройка. Можно указать, каким фронтам будет доступен сервер.
     * Так же можно указать анотацией над контроллерами
     * // @CrossOrigin(origins = "http://localhost:8080") // адреса доступных фронтов
     *
     * @return WebMvcConfigurerAdapter.
     */
    @Bean
    public WebMvcConfigurer corsConfiguration() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8080"); // адреса для доступности фронта
            }
        };
    }
}
