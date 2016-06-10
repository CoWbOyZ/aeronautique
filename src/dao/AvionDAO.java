package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Avion;

public class AvionDAO extends DAO<Avion>{

	private static final String TABLE = "avion";
	private static final String CLE_PRIMAIRE = "numav";

	private boolean isFreeToKill(int id){
		boolean test = true;
		try{
			ResultSet res = Connexion.executeQuery("SELECT numav FROM avion where numav = "+id) ;
			test = !res.next(); 
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return test;
	}

	@Override
	public boolean create(Avion avion) {
		boolean succes = true;
		try {
			String requete = "insert into "+TABLE+" (nomav, loc, capacite) values (?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, avion.getNom());
			pst.setString(2, avion.getLocalisation());
			pst.setInt(3, avion.getCapacite());
			pst.executeUpdate();

			avion.setNumero(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));

		} catch (Exception e) {
			e.printStackTrace();
			succes = false;
			System.out.println("creation failed");
		}

		return succes;
	}

	@Override
	public boolean delete(Avion avion) {
		boolean succes = true;
		if (isFreeToKill(avion.getNumero())) {
			try {
				int id = avion.getNumero();
				String requete = "delete from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
				PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (Exception e) {
				succes = false;
				e.printStackTrace();
			}
		} else {
			System.out.println("L'avion est présen sur un/des vol et ne peut pas être supprimé");
			succes = false;
		}
		return succes;
	}

	@Override
	public boolean update(Avion obj) {
		boolean succes = true;
		try {
			String requete = "update "+TABLE+" set nomav = ?, loc = ?, capacite = ? where numav= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, obj.getNom());
			pst.setString(2, obj.getLocalisation());
			pst.setInt(3, obj.getCapacite());
			pst.setInt(4, obj.getNumero());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			succes = false;
			System.out.println("creation failed");
		}

		return succes;
	}

	@Override
	public Avion find(int id) {
		Avion avion = new Avion();
		try {
			String requete = "select * from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			//ResultSet res = Connexion.executeQuery(pst);
			res.next();
			avion.setNumero(res.getInt(1));
			avion.setNom(res.getString(2));
			avion.setLocalisation(res.getString(3));
			avion.setCapacite(res.getInt(4));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return avion;
	}

}
