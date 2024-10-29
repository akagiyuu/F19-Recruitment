package tech.fcode.recruitment.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("Accept",
                                "Access-Control-Allow-Headers",
                                "Access-Control-Allow-Methods",
                                "Access-Control-Allow-Origin",
                                "Authorization",
                                "Content-Type",
                                "Origin",
                                "X-Requested-With")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH")
                        .exposedHeaders("Accept",
                                "Access-Control-Allow-Headers",
                                "Access-Control-Allow-Methods",
                                "Access-Control-Allow-Origin",
                                "Authorization",
                                "Content-Type",
                                "Origin",
                                "X-Requested-With");
            }
        };
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList(
                "Accept",
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Methods",
                "Access-Control-Allow-Origin",
                "Authorization",
                "Content-Type",
                "Origin",
                "X-Requested-With"));
        configuration.setExposedHeaders(Arrays.asList(
                "Accept",
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Methods",
                "Access-Control-Allow-Origin",
                "Authorization",
                "Content-Type",
                "Origin",
                "X-Requested-With"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
