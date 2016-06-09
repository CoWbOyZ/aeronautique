package aeronautique;

public class Avion {
	
	private int numero;
	private String nom;
	private String localisation;
	private int capacite;
	
	public Avion() {
		super();
	}
	
	public Avion(int numero, String nom, String loc, int capacite) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.localisation = loc;
		this.capacite = capacite;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	@Override
	public String toString() {
		return "Avion [numero=" + numero + ", nom=" + nom + ", loc=" + localisation + ", capacite=" + capacite + "]";
	}

}
