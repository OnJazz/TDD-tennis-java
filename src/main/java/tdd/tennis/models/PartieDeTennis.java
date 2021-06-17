package tdd.tennis.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe represente une partie de tennis entre deux joueur avec leurs scores.
 * @author Killian
 *
 */

@Document
public class PartieDeTennis {
	
	private String id;
	@Getter
	@Setter
	private boolean fini;

	@Getter
	private JoueurDeTennis joueur1;
	@Getter
	private JoueurDeTennis joueur2;
	
	@Getter
	private ScoreTennis scoreJoueur1;
	@Getter
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
