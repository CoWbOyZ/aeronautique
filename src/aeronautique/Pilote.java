package aeronautique;

public class Pilote {
	private int numeroPilote;
	private String nomPilote;
	private String adresse;
	private int salaire;
	
	public Pilote(int numeroPilote, String nomPilote, String adresse, int salaire) {
		super();
		this.numeroPilote = numeroPilote;
		this.nomPilote = nomPilote;
		this.adresse = adresse;
		this.salaire = salaire;
	}
	@Override
	public String toString() {
		return "Pilote [numeroPilote=" + numeroPilote + ", nomPilote=" + nomPilote + ", adresse=" + adresse
				+ ", salaire=" + salaire + "]";
	}
	
	
}
