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

}
