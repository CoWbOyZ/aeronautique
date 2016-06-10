package aeronautique;

import dao.Connexion;
import ihm.Fenetre;

public class Principale {

	public static void main(String[] args) {
		
		Fenetre fen = new Fenetre();
		//Connexion.afficheSelectEtoile("avion");
//		Vol vol = new VolDAO().find(1);
//		System.out.println(vol);
//		Vol vol = new Vol(1007,8,"Antananarivo","Phoenix", Timestamp.valueOf("2016-06-10 10:00:00.0"),Timestamp.valueOf("2016-06-10 12:00:00.0"));
//		(new VolDAO()).create(vol);
//		vol.setNumeroVol(16);
//		System.out.println(vol);
//		vol.setNumeroPilote(1004);
//		vol.setHeureArrivee(Timestamp.valueOf("2016-06-10 13:00:00"));
//		vol.setVilleArrivee("Le Caire");
//		System.out.println(vol);
//		(new VolDAO()).update(vol);
//		Vol verif = new VolDAO().find(16);
//		System.out.println(verif);
//		Pilote bogdan = new Pilote(1000,"bogdan","Rennes",15000);
//		Pilote hanan = new Pilote(1001,"hanan","Paris",20000);
//		new PiloteDAO().delete(hanan);
//		Avion avion = new Avion(2,"A320","paris",250);
//		new AvionDAO().delete(avion);
		Connexion.fermer();

	}

}
