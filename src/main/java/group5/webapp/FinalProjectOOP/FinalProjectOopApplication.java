package group5.webapp.FinalProjectOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FinalProjectOopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectOopApplication.class, args);
	}

}
