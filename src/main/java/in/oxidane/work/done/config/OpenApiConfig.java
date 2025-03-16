package in.oxidane.work.done.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${application.version:v0.0.1-SNAPSHOT}")
    private String applicationVersion;

    @Bean
    public OpenAPI workDoneOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Work Done Server API Documentation")
                        .description("API documentation for the Work Done application")
                        .version(applicationVersion)
                        .contact(new Contact()
                                .name("Oxidane Technology")
                                .url("https://oxidane.in")
                                .email("support@oxidane.in"))
                        .license(new License()
                                .name("API License")
                                .url("https://oxidane.in/license")))
                .servers(List.of(
                        new Server()
                                .url("/")
                                .description("Default Server URL")
                ));
    }
}
