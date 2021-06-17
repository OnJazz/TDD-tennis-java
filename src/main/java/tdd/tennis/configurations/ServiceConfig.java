package tdd.tennis.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import tdd.tennis.repositories.JoueurDeTennisRepository;
import tdd.tennis.repositories.PartieDeTennisRepository;
import tdd.tennis.repositories.ScoreTennisRepository;
import tdd.tennis.services.JoueurDeTennisService;
import tdd.tennis.services.PartieDeTennisService;
import tdd.tennis.services.ScoreTennisService;
import tdd.tennis.services.impl.JoueurDeTennisServiceImpl;
import tdd.tennis.services.impl.PartieDeTennisServiceImpl;
import tdd.tennis.services.impl.ScoreTennisServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public JoueurDeTennisService joueurDeTennisService(JoueurDeTennisRepository repo) {
		return new JoueurDeTennisServiceImpl(repo);
	}
	@Bean
	public ScoreTennisService joueurDeTennisService(ScoreTennisRepository repo) {
		return new ScoreTennisServiceImpl(repo);
	}
	@Bean
	public PartieDeTennisService partieDeTennisService(PartieDeTennisRepository repo) {
		return new PartieDeTennisServiceImpl(repo);
	}
}
