package tdd.tennis;

import lombok.Data;

/**
 * Cette classe represente une partie de tennis entre deux joueur avec leurs scores.
 * @author Killian
 *
 */

@Data
public class PartieDeTennis {
	
	private boolean fini;

	
	private JoueurDeTennis joueur1;
	private JoueurDeTennis joueur2;
	
	private ScoreTennis scoreJoueur1;
	private ScoreTennis scoreJoueur2;
	
	public PartieDeTennis(JoueurDeTennis joueur1, JoueurDeTennis joueur2, ScoreTennis scoreJoueur1,
			ScoreTennis scoreJoueur2) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.scoreJoueur1 = scoreJoueur1;
		this.scoreJoueur2 = scoreJoueur2;
	}
}
