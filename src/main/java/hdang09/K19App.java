package hdang09;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "F19 Recruitment API",
                version = "1.0.0",
                description = "An API for recruiting F19 generation."
        ),
        servers = { @Server(url = "https://recruit.hdang09.site") }
)
public class K19App {

    public static void main(String[] args) {
        SpringApplication.run(K19App.class, args);
    }

}
