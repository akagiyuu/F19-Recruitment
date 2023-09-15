package hdang09;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "K19 Recuitment API",
                version = "1.0.0",
                description = "An API for recuit K19."
        )
)
public class K19App {

    public static void main(String[] args) {
        SpringApplication.run(K19App.class, args);
    }

}
