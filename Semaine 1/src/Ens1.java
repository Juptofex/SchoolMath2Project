public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient à l'ensemble courant ssi tabE[e.val()] est à true.
	private int cardinal;

	public Ens1() {
		tabB = new boolean[MAX+1];
	}
	
	public boolean estVide() {
		return cardinal == 0 ;
	}
	
	public Elt unElement() {
		if (estVide())
			throw new MathException();
		for (int i = 1; i < tabB.length; i++) {
			if (tabB[i]) {
				return new Elt(i);
			}
		}
		return null;
	}

	public boolean contient(Elt e) {
		if (e == null || e.val()>=tabB.length)
			throw new IllegalArgumentException();
		return tabB[e.val()];
	}

	public void ajouter(Elt e) {
		if (e == null || e.val() >= tabB.length)
			throw new IllegalArgumentException();
		if (!tabB[e.val()]) {
			tabB[e.val()]=true;
			cardinal++;
		}

	}

	public void enlever(Elt e) {
		if (e == null || e.val() >= tabB.length)
			throw new IllegalArgumentException();
		if (tabB[e.val()]) {
			tabB[e.val()]=false;
			cardinal--;
		}
	}

	public int cardinal() {
		return cardinal ;
	}

	public void complementer() {
		for (int i = 1; i < tabB.length; i++) {
			if (tabB[i]) {
				tabB[i] = false;
			} else {
				tabB[i] = true;
			}
		}
		cardinal=MAX-cardinal;
	}

	public String toString() {
		String text="{";
		for (int i = 1; i < tabB.length; i++) {
			if (tabB[i])
				text+=i+",";
		}
		return text+"}";
	}
	
}
