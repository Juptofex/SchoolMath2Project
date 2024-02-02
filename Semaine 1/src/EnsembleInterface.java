/** Interface pour les classes Ensi ( i = 1,2,3,...).
 */

import java.util.*;

public interface EnsembleInterface {
	public static final int MAX = Elt.MAXELT.val();

	// renvoie true ssi l'ensemble courant est vide
	public boolean estVide();
	
	// renvoie un element de l'ensemble s'il n'est pas vide
	// lance une MathException si l'ensemble est vide
	public Elt unElement();

	// renvoie true ssi e appartient à l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public boolean contient(Elt e);

	// ajoute e (éventuellement) à l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public void ajouter(Elt e);

	// enlève e (éventuellement) de l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public void enlever(Elt e);

	// this <- complém. de this
	public void complementer();

	// renvoie le cardinal de l'ensemble courant
	public int cardinal();

	// renvoie une chaîne de caractère décrivant this en extension
	public String toString();

	// remplace this par this union a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void ajouter(EnsembleInterface a) {
		if (a==null)
			throw new IllegalArgumentException("Parameter 'a' cannot be null");
		for (int i = 1; i <= MAX; i++) {
			Elt x = new Elt(i);
			if (a.contient(x))
				this.ajouter(x);
		}
	}

	// remplace this par this moins a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void enlever(EnsembleInterface a) {
		//TODO
		if (a==null)
			throw new IllegalArgumentException();
		int index = a.cardinal();
		for (int i = 0; i < index; i++) {
			this.enlever(a.unElement());
			a.enlever(a.unElement());
		}
	}

	// remplace this par this inter a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void intersecter(EnsembleInterface a) {
		//TODO
		if (a==null)
			throw new IllegalArgumentException();
		int index = a.cardinal();
		EnsembleInterface temp = null;
		for (int i = 0; i < index; i++) {
			if (this.contient(a.unElement())) {
				temp.ajouter(a.unElement());
				a.enlever(a.unElement());
			}
		}
	}
	
} // interface
