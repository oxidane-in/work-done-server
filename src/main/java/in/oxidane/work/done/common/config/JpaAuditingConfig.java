package in.oxidane.work.done.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    private static final ZoneId IST_ZONE = ZoneId.of("Asia/Kolkata");

    @Bean
    public AuditorAware<String> auditorProvider() {
        //TODO: a hardcoded user until Spring Security is implemented
        return () -> Optional.of("system-user");
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now(IST_ZONE));
    }
}
