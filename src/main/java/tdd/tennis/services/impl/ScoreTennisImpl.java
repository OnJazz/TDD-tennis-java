package tdd.tennis.services.impl;



import tdd.tennis.models.ScoreTennis;
import tdd.tennis.repositories.ScoreTennisRepository;
import tdd.tennis.services.ScoreTennisService;

public class ScoreTennisImpl extends CRUDServiceImpl<ScoreTennis> implements ScoreTennisService{

	
	private ScoreTennisRepository repo;
	
	public ScoreTennisImpl(ScoreTennisRepository repo) {
		super(repo);
		this.repo = repo;
	}
	
	public void updateScore(ScoreTennis score, ScoreTennis scoreAdverse) {
		if(score.isDecisif()) {
			score.setPoint(score.getPoint() + 1);
			if (score.getPoint() >= 7 && (score.getPoint() - scoreAdverse.getPoint())==2) {
				updateJeux(score, scoreAdverse);
				resetPoint(score);
				resetPoint(scoreAdverse);
			}
		}
		else {
			updateScoreNotDecisif(score, scoreAdverse);
		}
	}
	
	public void updateScoreNotDecisif(ScoreTennis score, ScoreTennis scoreAdverse) {
		if(score.getPoint()<30) {
			score.setPoint(score.getPoint()+15);
		}
		else {
			score.setPoint(score.getPoint() + 10);
		}
		if(score.getPoint()>40) {
			updateJeux(score, scoreAdverse);
			resetPoint(score);
			resetPoint(scoreAdverse);
		}
	}
	
	public void updateJeux(ScoreTennis score, ScoreTennis scoreAdverse) {
		score.setJeux(score.getJeux()+1);
		if(score.getJeux() == 6 && scoreAdverse.getJeux()<=4) {
			this.updateSet(score);
		}
		if(score.getJeux() == 6 && scoreAdverse.getJeux()==6) {
			score.setDecisif(true);
			scoreAdverse.setDecisif(true);
		}
		if(score.getJeux() == 7 && scoreAdverse.getJeux() == 5) {
			this.updateSet(score);
		}
		if(score.getJeux() == 7 && scoreAdverse.getJeux() == 6) {
			score.setDecisif(false);
			this.updateSet(score);
		}
	}
	
	public void updateSet(ScoreTennis score) {
		score.setSet(score.getSet()+1);
		if(score.getSet()>=2) {
			score.setMatch(1);
		}
	}
	
	public void resetPoint(ScoreTennis score) {
		score.setPoint(0);
	}

}
