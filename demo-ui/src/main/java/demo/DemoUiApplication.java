package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoUiApplication extends SpringBootServletInitializer {
	@Bean
	public RestTemplate restTempate() {
		return new RestTemplate();
	}
	
	//Used when run as war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoUiApplication.class);
	}

	//Used when run as jar
	public static void main(String[] args) {
		SpringApplication.run(DemoUiApplication.class, args);
	}
}
