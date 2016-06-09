package aeronautique;

import sun.util.calendar.BaseCalendar.Date;

public class Vol {
	private int numeroVol;
	private String villeDepart;
	private String villeArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private int numeroPilote;
	private int numeroAvion;

	public Vol(int numeroVol, String villeDepart, String villeArrivee, Date heureDepart, Date heureArrivee) {
		super();
		this.numeroVol = numeroVol;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
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



	public Date getHeureDepart() {
		return heureDepart;
	}



	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}



	public Date getHeureArrivee() {
		return heureArrivee;
	}



	public void setHeureArrivee(Date heureArrivee) {
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
		return "Vol [numVol=" + numeroVol + ", villeDep=" + villeDepart + ", villeArr=" + villeArrivee + ", hDep=" + heureDepart
				+ ", hArr=" + heureArrivee + "]";
	}
	
}
