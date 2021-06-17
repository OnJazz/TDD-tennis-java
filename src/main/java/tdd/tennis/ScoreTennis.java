package tdd.tennis;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Représente le score d'un joueur de tennis.
 * @author Killian
 *
 */
@Data
@AllArgsConstructor
public class ScoreTennis {
	private int jeux;
	private int set;
	private int match;
}
