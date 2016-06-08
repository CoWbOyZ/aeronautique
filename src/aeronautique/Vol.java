package aeronautique;

import sun.util.calendar.BaseCalendar.Date;

public class Vol {
	private int numeroVol;
	private String villeDepart;
	private String villeArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	
	public Vol(int numVol, String villeDep, String villeArr, Date hDep, Date hArr) {
		super();
		this.numeroVol = numVol;
		this.villeDepart = villeDep;
		this.villeArrivee = villeArr;
		this.heureDepart = hDep;
		this.heureArrivee = hArr;
	}

	@Override
	public String toString() {
		return "Vol [numVol=" + numeroVol + ", villeDep=" + villeDepart + ", villeArr=" + villeArrivee + ", hDep=" + heureDepart
				+ ", hArr=" + heureArrivee + "]";
	}
	
}
