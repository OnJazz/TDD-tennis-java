package tdd.tennis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompteurPartieTennisTest {

	CompteurPartieTennis cptPartieTennis = new CompteurPartieTennis();
	JoueurDeTennis joueur1 = new JoueurDeTennis("Vennin", "Jason");
	JoueurDeTennis joueur2 = new JoueurDeTennis("Raoux", "Kilian");


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
		assertEquals(new ScoreTennis(0, 0, 0), partie.getScoreJoueur1());
		assertEquals(new ScoreTennis(0, 0, 0), partie.getScoreJoueur2());
	}
	
	@Test
	@DisplayName("Quand un joueur gagne un point, il passe de 0 à 15. Puis de 15 à 30. Puis de 30 à 40")
	public void test_nouvellePartie_scoreUpdate() {
		PartieDeTennis partie = cptPartieTennis.nouvellePartie(joueur1, joueur2);
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(15,partie.getScoreJoueur1().getJeux());
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(30,partie.getScoreJoueur1().getJeux());
		cptPartieTennis.joueurGagne(partie, joueur1);
		assertEquals(40,partie.getScoreJoueur1().getJeux());
	}
	

}
