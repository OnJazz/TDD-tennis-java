package tdd.tennis;

import lombok.Data;

/**
 * Représente le score d'un joueur de tennis.
 * @author Killian
 *
 */
@Data
public class ScoreTennis {

	private int point;
	private int jeux;
	private int set;
	private int match;
	private boolean avantage;

	
	public void updateScore() {
		if(this.point<30) {
			this.point+=15;
		}
		else {
			this.point += 10;
		}
	}
	
	public void updateJeux(ScoreTennis scoreAdverse) {
		this.jeux+=1;
		if(this.jeux == 6 && scoreAdverse.getJeux()<=4) {
			this.updateSet();
		}
		if(this.jeux == 7 && scoreAdverse.getJeux() == 5) {
			this.updateSet();
		}
	}
	
	public void updateSet() {
		this.set += 1;
	}
	
	public void resetPoint() {
		this.point = 0;
	}
}
