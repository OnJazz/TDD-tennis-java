package tdd.tennis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import tdd.tennis.models.ScoreTennis;

public interface ScoreTennisRepository extends MongoRepository<ScoreTennis, String>{

}
