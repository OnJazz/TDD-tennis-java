package tdd.tennis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdd.tennis.models.JoueurDeTennis;
import tdd.tennis.services.CRUDService;
import tdd.tennis.services.JoueurDeTennisService;

@RestController
@RequestMapping("joueurs")
@CrossOrigin
public class JoueurDeTennisController implements CRUDController<JoueurDeTennis>{
	
	@Autowired
	private JoueurDeTennisService service;

	@Override
	public CRUDService<JoueurDeTennis> getGenericService() {
		return this.service;
	}

}
