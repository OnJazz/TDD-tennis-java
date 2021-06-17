package tdd.tennis.models;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Represente un joueur de tennis. Un m�me joueur peut participer a plusieur
 * partie.
 * 
 * @author Killian
 *
 */
@Document
public class JoueurDeTennis {
	
	private String id;
	private String nom;
	private String prenom;
	
	public JoueurDeTennis(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
}
