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
			partie = updateAvantageJoueur1(partie);
		} else {
			partie = updateAvantageJoueur2(partie);
		}
		return partie;
	}
	
	/**
	 * gere les avantages quand le joueur 1 a gagné
	 * @param partie une partie de tennis
	 * @return une partie de tennis
	 */
	public PartieDeTennis updateAvantageJoueur1(PartieDeTennis partie) {
		if(partie.getScoreJoueur1().isAvantage()) {
			partie = Joueur1gagneUnJeu(partie);
		}
		partie.getScoreJoueur1().setAvantage(true);
		partie.getScoreJoueur2().setAvantage(false);
		return partie;
	}
	
	/**
	 * gere les avantages quand le joueur 2 a gagné
	 * @param partie une partie de tennis
	 * @return une partie de tennis
	 */
	public PartieDeTennis updateAvantageJoueur2(PartieDeTennis partie) {
		if(partie.getScoreJoueur2().isAvantage()) {
			partie = Joueur2gagneUnJeu(partie);
		}
		partie.getScoreJoueur2().setAvantage(true);
		partie.getScoreJoueur1().setAvantage(false);
		return partie;
	}
	
	/**
	 * reset les points des 2 joueurs a zero
	 * @param partie une partie de tennis
	 * @return une partie de tennis
	 */
	public PartieDeTennis resetPoints(PartieDeTennis partie) {
		partie.getScoreJoueur1().resetPoint();
		partie.getScoreJoueur2().resetPoint();
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
			if(partie.getScoreJoueur1().getPoint()>40) {
				partie = Joueur1gagneUnJeu(partie);
			}
			
		} else {
			partie.getScoreJoueur2().updateScore();
			if(partie.getScoreJoueur2().getPoint()>40) {
				partie = Joueur2gagneUnJeu(partie);
			}
		}
		return partie;
	}
	
	/**
	 * Joueur 2 gagne un jeu
	 * @param partie une partie de tennis
	 * @return une partie de tennis
	 */
	public PartieDeTennis Joueur2gagneUnJeu(PartieDeTennis partie) {
		partie.getScoreJoueur2().updateJeux(partie.getScoreJoueur1());
		partie = resetPoints(partie);
		return partie;
	}
	
	/**
	 * Joueur 1 gagne une jeu
	 * @param partie partie' de tennis
	 * @return une partie de tennis
	 */
	public PartieDeTennis Joueur1gagneUnJeu(PartieDeTennis partie) {
		partie.getScoreJoueur1().updateJeux(partie.getScoreJoueur2());
		partie = resetPoints(partie);
		return partie;
	}
}
