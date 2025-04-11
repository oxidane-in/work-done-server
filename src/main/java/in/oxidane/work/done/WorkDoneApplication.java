package in.oxidane.work.done;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class WorkDoneApplication {

	public static void main(String[] args) {
		log.info("Starting WorkDone application");
		ApplicationContext context = SpringApplication.run(WorkDoneApplication.class, args);
		log.info("WorkDone application started successfully");
		log.debug("Active profiles: {}", String.join(", ", context.getEnvironment().getActiveProfiles()));
	}

}
