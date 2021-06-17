package tdd.tennis.services.impl;


import tdd.tennis.models.PartieDeTennis;
import tdd.tennis.repositories.PartieDeTennisRepository;
import tdd.tennis.services.PartieDeTennisService;

public class PartieDeTennisServiceImpl extends CRUDServiceImpl<PartieDeTennis> implements PartieDeTennisService {

	private PartieDeTennisRepository repo;
	
	public PartieDeTennisServiceImpl(PartieDeTennisRepository repo) {
		super(repo);
		this.repo = repo;
	}
}
