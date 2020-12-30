package ua.roman.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class FlatAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatAppApplication.class, args);
	}

}
