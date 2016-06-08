package aeronautique;

public class Avion {
	
	private int numero;
	private String nom;
	private String localisation;
	private int capacite;
	
	public Avion(int numero, String nom, String loc, int capacite) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.localisation = loc;
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Avion [numero=" + numero + ", nom=" + nom + ", loc=" + localisation + ", capacite=" + capacite + "]";
	}

}
