package tdd.tennis;

/**
 * Cette classe contient tout le code permettant de calculer les points au
 * tennis.
 * 
 * @author Killian
 *
 */
public class CompteurPartieTennis {

	/**
	 * Cette Methode permet de créer une nouvelle partie de tennis. Une partie
	 * contient 2 joueurs et 2 Scores Au debut de la partie, les score sont a 0.
	 * 
	 * @param joueur1 premier joueur de la partie
	 * @param joueur2 deuxieme joueur de la partie
	 * @return une nouvelle partie.
	 */
	public PartieDeTennis nouvellePartie(JoueurDeTennis joueur1, JoueurDeTennis joueur2) {
		return new PartieDeTennis(joueur1, joueur2, new ScoreTennis(), new ScoreTennis());
	}

	/**
	 * Cette methode doit etre appeler lors ce qu'un joueur gagne un point.
	 * 
	 * @param partie  qui est jouer.
	 * @param gagnant Joueur qui a gagner.
	 * @return La partie avec les nouveaux scores.
	 */
	public PartieDeTennis joueurGagne(PartieDeTennis partie, JoueurDeTennis gagnant) {
		if (egalite(partie)) {
			partie = updateAvantage(partie, gagnant);
		} else {
			partie = updatePoint(partie, gagnant);
		}
		return partie;
	}

	/**
	 * regarde si egalite a 40 point
	 * @param partie
	 * @return un boolean
	 */
	public boolean egalite(PartieDeTennis partie) {
		return partie.getScoreJoueur1().getPoint() == 40 && partie.getScoreJoueur2().getPoint() == 40;
	}

	/**
	 * mets l'avantage au joueur gagnant
	 * @param partie une partie de tennis
	 * @param gagnant le joueur gagnant
	 * @return la partie mise a jour
	 */
	public PartieDeTennis updateAvantage(PartieDeTennis partie, JoueurDeTennis gagnant) {
		if (gagnant.equals(partie.getJoueur1())) {
			partie.getScoreJoueur1().setAvantage(true);
		} else {
			partie.getScoreJoueur2().setAvantage(true);
		}
		return partie;
	}
	
	/**
	 * Mets les points au joueurs gagnant
	 * @param partie une partie de tennis
	 * @param gagnant le joueur gagnant
	 * @return la partie mise a jour
	 */
	public PartieDeTennis updatePoint(PartieDeTennis partie, JoueurDeTennis gagnant) {
		if (gagnant.equals(partie.getJoueur1())) {
			partie.getScoreJoueur1().updateScore();
		} else {
			partie.getScoreJoueur2().updateScore();
		}
		return partie;
	}
}
