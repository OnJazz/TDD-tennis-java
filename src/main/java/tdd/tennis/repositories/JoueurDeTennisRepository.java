package tdd.tennis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import tdd.tennis.models.JoueurDeTennis;

public interface JoueurDeTennisRepository extends MongoRepository<JoueurDeTennis, String>{

}
