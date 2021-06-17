package tdd.tennis;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Cette classe represente une partie de tennis entre deux joueur avec leurs scores.
 * @author Killian
 *
 */
@AllArgsConstructor
@Data
public class PartieDeTennis {

	private JoueurDeTennis joueur1;
	private JoueurDeTennis joueur2;
	
	private ScoreTennis scoreJoueur1;
	private ScoreTennis scoreJoueur2;
}
