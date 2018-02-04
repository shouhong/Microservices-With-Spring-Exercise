package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Try3ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Try3ServerApplication.class, args);
	}
}
