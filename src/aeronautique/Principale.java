package aeronautique;

import dao.AvionDAO;
import dao.Connexion;

public class Principale {

	public static void main(String[] args) {
		//Connexion.afficheSelectEtoile("avion");
		Avion avion = new AvionDAO().find(1);
		System.out.println(avion);
		Avion avion2 = new Avion(-1,"A320","Caen",350);
		(new AvionDAO()).create(avion2);
		System.out.println(avion2);
		avion2.setCapacite(220);
		avion2.setLocalisation("Tombouctou");
		(new AvionDAO()).update(avion2);
		Connexion.fermer();
		
	}

}
