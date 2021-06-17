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
		for (int i = 0; i < 3; i++) {
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		}
		for (int i = 0; i < 3; i++) {
			partie = cptPartieTennis.joueurGagne(partie, joueur2);
		}
		return partie;
	}

	@Test
	@DisplayName("un utilisateur peut créer une nouvelle partie")
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
		assertEquals(0, partie.getScoreJoueur1().getPoint());
		assertEquals(0, partie.getScoreJoueur2().getPoint());
	}

	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 0 à 15. Puis de 15 à 30. Puis de 30 à 40")
	public void test_nouvellePartie_scoreUpdate() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(15, partie.getScoreJoueur1().getPoint());
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(30, partie.getScoreJoueur1().getPoint());
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(40, partie.getScoreJoueur1().getPoint());
	}

	@Test
	@DisplayName("Si les deux joueurs sont a egalité a 40 points, si aucun joueur a un avantage,"
			+ " le joueur qui gagne le point gagne un avantage")
	public void test_nouvellePartie_scoreAvantageJoueur2() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertTrue(partie.getScoreJoueur2().isAvantage());
	}

	@Test
	@DisplayName("Si les deux joueurs sont a egalité a 40 points, si aucun joueur a un avantage,"
			+ " le joueur qui gagne le point gagne un avantage")
	public void test_nouvellePartie_scoreAvantageJoueur1() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertTrue(partie.getScoreJoueur1().isAvantage());
	}

	@Test
	@DisplayName("Si les deux joueurs sont a egalité a 40 points, si le perdant a un avantage, alors il le perd")
	public void test_nouvellePartie_scorePerdAvantage() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertFalse(partie.getScoreJoueur1().isAvantage());
	}

	@Test
	@DisplayName("Si les deux joueurs sont a egalité a 40 points, si le gagnant a un avantage, alors il gagne le jeu.")
	public void test_nouvellePartie_scoreJoueur1GagneJeu() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(partie.getScoreJoueur1().getJeux(), 1);
	}

	@Test
	@DisplayName("Si les deux joueurs sont a egalité a 40 points, si le gagnant a un avantage, alors il gagne le jeu.")
	public void test_nouvellePartie_scoreJoueur2GagneJeu() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(partie.getScoreJoueur2().getJeux(), 1);
	}

	@Test
	@DisplayName("Quand un jeu est gagné, alors les deux joueurs retournent à 0 point")
	public void test_nouvellePartie_0pointApresJeu() {
		PartieDeTennis partie = initEgalite();
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(0, partie.getScoreJoueur1().getPoint());
		assertEquals(0, partie.getScoreJoueur2().getPoint());
	}

	@Test
	@DisplayName("Quand un joueur arrive à gagner 6 jeux et que son adversaire 4 ou moins jeux gagnés, alors le joueur gagne un set")
	public void test_nouvellePartie_gagneUnSetJoueur1() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(5);
		partie.getScoreJoueur2().setJeux(4);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(1, partie.getScoreJoueur1().getSet());
	}

	@Test
	@DisplayName("Quand un joueur arrive à gagner 6 jeux et que son adversaire 4 ou moins jeux gagnés, alors le joueur gagne un set")
	public void test_nouvellePartie_gagneUnSetJoueur2() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(4);
		partie.getScoreJoueur2().setJeux(5);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(1, partie.getScoreJoueur2().getSet());
	}

	@Test
	@DisplayName("Quand les deux joueurs ont 5 points alors faut avoir 2 points d'avance et 7 jeux pour gagner le set")
	public void test_nouvellePartie_gagneSet5v7() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(5);
		partie.getScoreJoueur2().setJeux(6);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur2);
		assertEquals(1, partie.getScoreJoueur2().getSet());
	}

	@Test
	@DisplayName("Quand les deux joueurs ont 6 jeux gagné, alors on passe en jeux decisif")
	public void test_nouvellePartie_JeuxDecisif() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(5);
		partie.getScoreJoueur2().setJeux(6);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertTrue(partie.getScoreJoueur1().isDecisif());
		assertTrue(partie.getScoreJoueur2().isDecisif());
	}

	@Test
	@DisplayName("Quand il y a jeu décisif les points sont compté par point")
	public void test_nouvellePartie_JeuxDecisifPoint() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(6);
		partie.getScoreJoueur1().setDecisif(true);
		partie.getScoreJoueur2().setDecisif(true);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(1, partie.getScoreJoueur1().getPoint());
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(2, partie.getScoreJoueur1().getPoint());
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(3, partie.getScoreJoueur1().getPoint());
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(4, partie.getScoreJoueur1().getPoint());
	}

	@Test
	@DisplayName("Si un joueur gagne un point pendant un jeu decisif il passe de 0 à 1, puis 2, ... jusqu'à 7")
	public void test_nouvellePartie_JeuxDecisifPointJusque7() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(6);
		partie.getScoreJoueur1().setDecisif(true);
		partie.getScoreJoueur2().setDecisif(true);
		for (int i = 0; i < 7; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(7, partie.getScoreJoueur1().getPoint());
	}

	@Test
	@DisplayName("Il faut avoir deux points d'avance pour gagner le jeu et donc le set")
	public void test_nouvellePartie_JeuxDecisifPointEcartNotWin() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(6);
		partie.getScoreJoueur1().setDecisif(true);
		partie.getScoreJoueur2().setDecisif(true);
		for (int i = 0; i < 6; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		for (int i = 0; i < 6; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(0, partie.getScoreJoueur1().getSet());
	}

	@Test
	@DisplayName("Il faut avoir deux points d'avance pour gagner le jeu et donc le set")
	public void test_nouvellePartie_JeuxDecisifPointEcartWin() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(6);
		partie.getScoreJoueur1().setDecisif(true);
		partie.getScoreJoueur2().setDecisif(true);
		for (int i = 0; i < 8; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		for (int i = 0; i < 8; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur2);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(1, partie.getScoreJoueur1().getSet());
	}

	@Test
	@DisplayName("Le premier joueur a 2 sets gagnés gagne la partie.")
	public void test_nouvellePartie_2SetWin() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setSet(1);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(5);
		for (int i = 0; i < 4; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(1, partie.getScoreJoueur1().getMatch());
	}

	@Test
	@DisplayName("Quand un joueur a gagné, il n'est plus possible de changer les scores")
	public void test_nouvellePartie_CantScoreWin() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setSet(1);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(5);
		for (int i = 0; i < 4; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		int score1avant = partie.getScoreJoueur1().getPoint();
		partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(partie.getScoreJoueur1().getPoint(), score1avant);
	}

	@Test
	@DisplayName("L'utilisateur doit être avertie que la partie est finie")
	public void test_nouvellePartie_isFinish() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		partie.getScoreJoueur1().setSet(1);
		partie.getScoreJoueur1().setJeux(6);
		partie.getScoreJoueur2().setJeux(5);
		for (int i = 0; i < 4; i++)
			partie = cptPartieTennis.joueurGagne(partie, joueur1);
		assertTrue(partie.isFini());
	}
}
