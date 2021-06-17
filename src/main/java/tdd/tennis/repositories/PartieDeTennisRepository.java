package tdd.tennis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import tdd.tennis.models.PartieDeTennis;

public interface PartieDeTennisRepository extends MongoRepository<PartieDeTennis, String>{

}
