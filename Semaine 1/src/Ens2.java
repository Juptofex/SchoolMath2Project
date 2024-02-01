public class Ens2 extends EnsembleAbstrait {

	private Elt[] elements; // contient les elements de l'ensemble. Il ne peut pas y avoir de doublon.
	private int cardinal;

	public Ens2() {
		elements=new Elt[MAX];
	}

	public boolean estVide() {
		return cardinal==0;
	}
	
	public Elt unElement() {
		if (estVide())
			throw new MathException();
		return elements[0];
	}

	public boolean contient(Elt e) {
		if (e == null)
			throw new IllegalArgumentException();
		if (estVide())
			return false;
		for (int i = 0; i < cardinal; i++) {
			if (elements[i].equals(e))
				return true;
		}
		return false ;
	}

	public void ajouter(Elt e) {
		if (e==null)
			throw new IllegalArgumentException();
		if (!contient(e)) {
			elements[cardinal] = e;
			cardinal++;
		}
	}

	public void enlever(Elt e) {
		if (e==null)
			throw new IllegalArgumentException();
		boolean index=false;
		for (int i = 0; i < cardinal; i++) {
			if (elements[i].equals(e)) {
				index=true;
				cardinal--;
			}
			if (index) {
				elements[i]=elements[i+1];
			}
		}
	}

	public int cardinal() {
		return cardinal;
	}

	public void complementer() {
		//TODO;
		Elt[] temp = new Elt[MAX];
		int index=0;
		for (int i = 1; i < MAX+1; i++) {
			Elt x = new Elt(i);
			if (!contient(x)) {
				temp[index] = x;
				index++;
			}
		}
		elements=temp;
		cardinal=index;
	}

	public String toString() {
		String text="{";
		for (int i = 0; i < cardinal; i++) {
			text+=elements[i].val()+",";
		}
		return text+"}";
	}

}
