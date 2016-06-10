package aeronautique;

public class Vol {
	private int numeroVol;
	private int numeroPilote;
	private int numeroAvion;
	private String villeDepart;
	private String villeArrivee;
	private java.sql.Timestamp heureDepart;
	private java.sql.Timestamp heureArrivee;

	public Vol( 
			int numeroPilote, 
			int numeroAvion, 
			String villeDepart, 
			String villeArrivee, 
			java.sql.Timestamp heureDepart, 
			java.sql.Timestamp heureArrivee) {
		super();
		this.numeroPilote = numeroPilote;
		this.numeroAvion = numeroAvion;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}
	
	public Vol() {
		super();
	}

	public int getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(int numeroVol) {
		this.numeroVol = numeroVol;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public java.sql.Timestamp getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(java.sql.Timestamp heureDepart) {
		this.heureDepart = heureDepart;
	}

	public java.sql.Timestamp getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(java.sql.Timestamp heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public int getNumeroPilote() {
		return numeroPilote;
	}

	public void setNumeroPilote(int numeroPilote) {
		this.numeroPilote = numeroPilote;
	}

	public int getNumeroAvion() {
		return numeroAvion;
	}

	public void setNumeroAvion(int numeroAvion) {
		this.numeroAvion = numeroAvion;
	}

	
	@Override
	public String toString() {
		return "Vol [numeroVol=" + numeroVol + ", numeroPilote=" + numeroPilote + ", numeroAvion=" + numeroAvion
				+ ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", heureDepart=" + heureDepart
				+ ", heureArrivee=" + heureArrivee + "]";
	}	
	
}