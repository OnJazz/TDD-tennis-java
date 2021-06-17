package tdd.tennis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tdd.tennis.models.PartieDeTennis;
import tdd.tennis.services.CRUDService;
import tdd.tennis.services.PartieDeTennisService;

@RestController
@RequestMapping("parties")
@CrossOrigin
public class PartieDeTennisController implements CRUDController<PartieDeTennis>{

	@Autowired
	private PartieDeTennisService service;
	
	@Override
	public CRUDService<PartieDeTennis> getGenericService() {
		return this.service;
	}

}
