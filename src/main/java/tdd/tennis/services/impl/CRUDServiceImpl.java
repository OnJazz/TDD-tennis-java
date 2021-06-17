package tdd.tennis.services.impl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import tdd.tennis.services.CRUDService;

public class CRUDServiceImpl<T> implements CRUDService<T> {

	private MongoRepository<T, String> repo;

	public CRUDServiceImpl(MongoRepository<T, String> repo) {
		this.repo = repo;
	}

	@Override
	public List<T> findAll() {
		return repo.findAll();
	}

	@Override
	public T get(String id) {
		return repo.findById(id).get();
	}

	@Override
	public T save(T obj) {
		return repo.save(obj);
	}

	@Override
	public T update(T obj) {
		return repo.save(obj);
	}

	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}
}