package tdd.tennis.services.impl;


import tdd.tennis.models.PartieDeTennis;
import tdd.tennis.repositories.PartieDeTennisRepository;
import tdd.tennis.services.PartieDeTennisService;

public class PartieDeTennisImpl extends CRUDServiceImpl<PartieDeTennis> implements PartieDeTennisService {

	private PartieDeTennisRepository repo;
	
	public PartieDeTennisImpl(PartieDeTennisRepository repo) {
		super(repo);
		this.repo = repo;
	}
}
