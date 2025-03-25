package in.oxidane.work.done.common.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Getter
@Slf4j
@Configuration
public class DatabaseInitializationConfig {

    // These getters will be used in the Liquibase changelog
    @Value("${app.run.create-tables:false}")
    private boolean shouldRunCreateTables;

    @Value("${app.run.insert-data:false}")
    private boolean shouldRunInsertData;

    @Value("${app.run.migrations:true}")
    private boolean shouldRunMigrations;

}
