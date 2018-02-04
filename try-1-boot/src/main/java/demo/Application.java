package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	//Used when run as war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	//Used when run as jar
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> set = new HashSet<>();
		set.add(new Player("Big Easy", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		
		list.add(new Team("Harlem", "Globetrotters", set));
		list.add(new Team("Washington","Generals",null));

		teamRepository.save(list);
	}
	
	@Autowired TeamRepository teamRepository;
}
