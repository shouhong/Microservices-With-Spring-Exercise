package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Team;
import demo.repository.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired TeamRepository teamRepository;
	
	@GetMapping("/hiteams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}
}
