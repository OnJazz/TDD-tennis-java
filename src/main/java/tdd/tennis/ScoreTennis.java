package tdd.tennis;

import lombok.Data;

/**
 * Représente le score d'un joueur de tennis.
 * @author Killian
 *
 */
@Data
public class ScoreTennis {
	private int jeux;
	private int set;
	private int match;
	
	public ScoreTennis(int jeux, int set, int match) {
		this.jeux = jeux;
		this.set = set;
		this.match = match;
	}
}
