package me.fabiomaffioletti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApplicationPropertiesApplication {

	@Bean
	public ApplicationPropertiesBindingPostProcessor applicationPropertiesBindingPostProcessor() {
		return new ApplicationPropertiesBindingPostProcessor();
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringApplicationPropertiesApplication.class, args); //NOSONAR
	}

}
