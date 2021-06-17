package tdd.tennis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdd.tennis.models.ScoreTennis;
import tdd.tennis.services.CRUDService;
import tdd.tennis.services.ScoreTennisService;

@RestController
@RequestMapping("scores")
@CrossOrigin
public class ScoreTennisController implements CRUDController<ScoreTennis>{

	@Autowired
	private ScoreTennisService service;
	
	@Override
	public CRUDService<ScoreTennis> getGenericService() {
		return service;
	}

}
