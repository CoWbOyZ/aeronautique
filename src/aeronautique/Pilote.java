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
	
	public int getNumeroPilote() {
		return numeroPilote;
	}
	public void setNumeroPilote(int numeroPilote) {
		this.numeroPilote = numeroPilote;
	}
	public String getNomPilote() {
		return nomPilote;
	}
	public void setNomPilote(String nomPilote) {
		this.nomPilote = nomPilote;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	
}
