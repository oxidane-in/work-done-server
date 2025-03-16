package in.oxidane.work.done;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WorkDoneApplication {

	private static final Logger logger = LoggerFactory.getLogger(WorkDoneApplication.class);

	public static void main(String[] args) {
		logger.info("Starting WorkDone application");
		ApplicationContext context = SpringApplication.run(WorkDoneApplication.class, args);
		logger.info("WorkDone application started successfully");
		logger.debug("Active profiles: {}", String.join(", ", context.getEnvironment().getActiveProfiles()));
	}

}
