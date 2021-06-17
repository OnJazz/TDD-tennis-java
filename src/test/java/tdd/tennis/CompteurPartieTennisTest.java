package tdd.tennis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompteurPartieTennisTest {

	CompteurPartieTennis cptPartieTennis = new CompteurPartieTennis();
	JoueurDeTennis joueur1 = new JoueurDeTennis("Vennin", "Jason");
	JoueurDeTennis joueur2 = new JoueurDeTennis("Raoux", "Kilian");
	
	public PartieDeTennis initEgalite() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur1);
		cptPartieTennis.joueurGagne(partie, joueur1);
		cptPartieTennis.joueurGagne(partie, joueur1);
		cptPartieTennis.joueurGagne(partie, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur2);
		return partie;
	}


	@Test
	@DisplayName("un utilisateur peut cr�er une nouvelle partie")
	public void test_nouvellePartie_retournePartie() {
		assertTrue(cptPartieTennis.nouvellePartie(null, null) instanceof PartieDeTennis);
	}
	
	@Test
	@DisplayName("un utilisateur peut choisir les 2 joueurs qui joueront la partie")
	public void test_nouvellePartie_choisirJoueur() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		assertTrue(partie.getJoueur1().equals(joueur1));
		assertTrue(partie.getJoueur2().equals(joueur2));
	}
	
	@Test
	@DisplayName("au debut de la partie les 2 joueurs ont zero points")
	public void test_nouvellePartie_score() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		assertEquals(new ScoreTennis(), partie.getScoreJoueur1());
		assertEquals(new ScoreTennis(), partie.getScoreJoueur2());
	}
	
	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 0 � 15. Puis de 15 � 30. Puis de 30 � 40")
	public void test_nouvellePartie_scoreUpdate() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(15,partie.getScoreJoueur1().getPoint());
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(30,partie.getScoreJoueur1().getPoint());
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(40,partie.getScoreJoueur1().getPoint());
	}
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si aucun joueur a un avantage,"
			+ " le joueur qui gagne le point gagne un avantage")
	public void test_nouvellePartie_scoreAvantageJoueur2() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur2);
		assertTrue(partie.getScoreJoueur2().isAvantage());
	}
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si aucun joueur a un avantage,"
			+ " le joueur qui gagne le point gagne un avantage")
	public void test_nouvellePartie_scoreAvantageJoueur1() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertTrue(partie.getScoreJoueur1().isAvantage());
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si le perdant a un avantage, alors il le perd")
	public void test_nouvellePartie_scorePerdAvantage() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur1);
		cptPartieTennis.joueurGagne(partie, joueur2);
		assertFalse(partie.getScoreJoueur1().isAvantage());
	}
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si le gagnant a un avantage, alors il gagne le jeu.")
	public void test_nouvellePartie_scoreJoueur1GagneJeu() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur1);
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(partie.getScoreJoueur1().getJeux(),1);
	}
	@Test
	@DisplayName("Si les deux joueurs sont a egalit� a 40 points, si le gagnant a un avantage, alors il gagne le jeu.")
	public void test_nouvellePartie_scoreJoueur2GagneJeu() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(partie.getScoreJoueur2().getJeux(),1);
	}
	
	@Test
	@DisplayName("Quand un jeu est gagn�, alors les deux joueurs retournent � 0 point")
	public void test_nouvellePartie_0pointApresJeu() {
		PartieDeTennis partie = initEgalite();
		cptPartieTennis.joueurGagne(partie, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(0, partie.getScoreJoueur1().getPoint());
		assertEquals(0, partie.getScoreJoueur2().getPoint());
	}

}
