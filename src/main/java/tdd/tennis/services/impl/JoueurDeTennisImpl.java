package tdd.tennis.services.impl;

import tdd.tennis.models.JoueurDeTennis;
import tdd.tennis.repositories.JoueurDeTennisRepository;
import tdd.tennis.services.JoueurDeTennisService;

public class JoueurDeTennisImpl extends CRUDServiceImpl<JoueurDeTennis> implements JoueurDeTennisService {

	private JoueurDeTennisRepository repo;

	public JoueurDeTennisImpl(JoueurDeTennisRepository repo) {
		super(repo);
		this.repo = repo;
	}

}
