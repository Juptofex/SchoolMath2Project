/** Classe Relation héritant de RelationDeBase
	 Fournit des outils de manipulation des relations entre sous-ensembles de l'Univers
 */

import java.util.*;

public class Relation extends RelationDeBase {

	/** Valeur numérique de MAXELT */
	private static final int MAX = Elt.MAXELT.val();

	/** Construit la Relation vide sur l'ensemble vide */
	public Relation() {
		super();
	}

	/** Construit la Relation vide de d vers a */
	public Relation(EnsembleAbstrait d, EnsembleAbstrait a) {
		super(d, a);
	}

	/** Clone */
	public Relation clone() {
		return (Relation) super.clone();
	}
	
	//Ex1
	//renvoie le domaine de la relation courante
	public EnsembleAbstrait domaine() {
		EnsembleAbstrait temp = new Ensemble();
		for (Couple c: this) {
			temp.ajouter(c.getX());
		}
		return temp;
	}
	
	//renvoie l'image de la relation courante
	public EnsembleAbstrait image() {
		EnsembleAbstrait temp = new Ensemble();
		for (Couple c: this) {
			temp.ajouter(c.getY());
		}
		return temp;
	}
	
	// EX 2
	// renvoie la complémentaire de la relation courante
	public Relation complementaire() {
		Relation temp = new Relation(depart(), arrivee());
		for (Elt x : depart()) {
			for (Elt y : arrivee()) {
				Couple tempC = new Couple(x, y);
				if (!contient(tempC)) {
					temp.ajouter(tempC);
				}
			}
		}
		return temp;
	}

	// renvoie la réciproque de la relation courante
	public Relation reciproque() {
		Relation temp = new Relation(arrivee(), depart());
		for (Couple c : this) {
			temp.ajouter(c.reciproque());
		}
		return temp;
	}

	// si possible, remplace la relation courante par son union avec r
	//sinon, lance une IllegalArgumentException
	public void ajouter(RelationInterface r) {
		if (r==null||!this.arrivee().equals(r.arrivee())||!this.depart().equals(r.depart()))
			throw new IllegalArgumentException();
		for (Couple c : r) {
			if (!contient(c))
				this.ajouter(c);
		}
	}

	// si possible, remplace this par sa différence avec r
	//sinon, lance une IllegalArgumentException
	public void enlever(RelationInterface r) {
		if (r==null||!this.arrivee().equals(r.arrivee())||!this.depart().equals(r.depart()))
			throw new IllegalArgumentException();
		for (Couple c : this.clone()) {
			if (r.contient(c))
				this.enlever(c);
		}
	}

	// si possible, remplace this par son intersection avec r
	//sinon, lance une IllegalArgumentException
	public void intersecter(RelationInterface r) {
		if (r==null||!this.arrivee().equals(r.arrivee())||!this.depart().equals(r.depart()))
			throw new IllegalArgumentException();
		for (Couple c : this.clone()) {
			if (!r.contient(c))
				this.enlever(c);
		}
	}

	// si possible, renvoie la composée : this après r
	//sinon, lance une IllegalArgumentException
	public Relation apres(RelationInterface r) {
		//TODO
		return null;
	}


	
	/*Les exercices 4 et 5 ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	
	/* Ex 4 */
		
	// Clôture la Relation courante pour la réflexivité
	public void cloReflex() {
		//TODO
	}

	// Clôture la Relation courante pour la symétrie
	public void cloSym() {
		//TODO
	}

	// Clôture la Relation courante pour la transitivité (Warshall)
	public void cloTrans() {
		//TODO
	}
	
	
	//Ex 5
	/*Les questions qui suivent ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	// renvoie true ssi this est réflexive
	public boolean reflexive(){
		//TODO
		return false;
	}

	// renvoie true ssi this est antiréflexive
	public boolean antireflexive(){
		//TODO
		return false;
	}

	// renvoie true ssi this est symétrique
	public boolean symetrique(){
		//TODO
		return false;
	}

	// renvoie true ssi this est antisymétrique
	public boolean antisymetrique(){
		//TODO
		return false;
	}

	// renvoie true ssi  this est transitive
	public boolean transitive(){
		//TODO
		return false;
	}
	
	// Ex 6
	//Construit une copie de la relation en paramètre
	//lance une IllegalArgumentException en cas de paramètre invalide
	public Relation(RelationInterface r) {
		//TODO
		this();

	}

	//renvoie l'identité sur e
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation identite(EnsembleAbstrait e) {
		//TODO
		return null;
	}

	//renvoie le produit cartésien de a et b
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation produitCartesien(EnsembleAbstrait a, EnsembleAbstrait b) {
			//TODO
		return null;
	}

} // class Relation
