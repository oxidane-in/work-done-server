package in.oxidane.work.done.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.logging")
public class LoggingProperties {
    private boolean enabled = true;
    private boolean includeRequestBody = true;
    private boolean includeResponseBody = true;
    private boolean includeHeaders = false;
    private int maxBodyLength = 1000;
}
