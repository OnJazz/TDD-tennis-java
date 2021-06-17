package tdd.tennis.services.impl;

import org.springframework.stereotype.Service;

import tdd.tennis.models.JoueurDeTennis;
import tdd.tennis.repositories.JoueurDeTennisRepository;
import tdd.tennis.services.JoueurDeTennisService;

@Service
public class JoueurDeTennisServiceImpl extends CRUDServiceImpl<JoueurDeTennis> implements JoueurDeTennisService {

	private JoueurDeTennisRepository repo;
	
	public JoueurDeTennisServiceImpl(JoueurDeTennisRepository repo) {
		super(repo);
		this.repo = repo;
	}

}
