package tdd.tennis.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Repr�sente le score d'un joueur de tennis.
 * @author Killian
 *
 */
@Document
public class ScoreTennis {
	
	private String id;

	@Getter
	@Setter
	private int point;
	@Getter
	@Setter
	private int jeux;
	
	@Getter
	@Setter
	private int set;
	
	@Getter
	@Setter
	private int match;
	
	@Getter
	@Setter
	private boolean avantage;
	
	@Getter
	@Setter
	private boolean decisif;

	
	public void updateScore(ScoreTennis scoreAdverse) {
		if(decisif) {
			this.point += 1;
			if(this.point>=7 && (this.point - scoreAdverse.getPoint())==2) {
				updateJeux(scoreAdverse);
				this.resetPoint();
				scoreAdverse.resetPoint();
			}
		}
		else {
			updateScoreNotDecisif(scoreAdverse);
		}
		
	}
	public void updateScoreNotDecisif(ScoreTennis scoreAdverse) {
		if(this.point<30) {
			this.point+=15;
		}
		else {
			this.point += 10;
		}
		if(this.point>40) {
			updateJeux(scoreAdverse);
			this.resetPoint();
			scoreAdverse.resetPoint();
		}
	}
	
	public void updateJeux(ScoreTennis scoreAdverse) {
		this.jeux+=1;
		if(this.jeux == 6 && scoreAdverse.getJeux()<=4) {
			this.updateSet();
		}
		if(this.jeux == 6 && scoreAdverse.getJeux()==6) {
			this.decisif = true;
			scoreAdverse.setDecisif(true);
		}
		if(this.jeux == 7 && scoreAdverse.getJeux() == 5) {
			this.updateSet();
		}
		if(this.jeux == 7 && scoreAdverse.getJeux() == 6) {
			this.decisif = false;
			this.updateSet();
		}
	}
	
	public void updateSet() {
		this.set += 1;
		if(set>=2) {
			this.match =1;
		}
	}
	
	public void resetPoint() {
		this.point = 0;
	}
}
