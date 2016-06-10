package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Pilote;

public class PiloteDAO extends DAO<Pilote>{

	private static final String TABLE = "pilote";
	private static final String CLE_PRIMAIRE = "numPil";

	private boolean isFreeToKill(int id){
		boolean test = true;
		try{
			ResultSet res = Connexion.executeQuery("SELECT numpil FROM vol where numpil="+id) ;
			test = !res.next();
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative : " + e.getMessage()) ;
		}
		return test;
	}

	@Override
	public boolean create(Pilote pilote) {
		boolean succes = true;
		try {
			String requete = "insert into "+TABLE+" (nompil, adr, sal) values (?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, pilote.getNomPilote());
			pst.setString(2, pilote.getAdresse());
			pst.setInt(3, pilote.getSalaire());
			pst.executeUpdate();

			pilote.setNumeroPilote(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));

		} catch (Exception e) {
			e.printStackTrace();
			succes = false;
			System.out.println("creation failed");
		}

		return succes;
	}

	@Override
	public boolean delete(Pilote pilote) {
		boolean succes = true;
		if (isFreeToKill(pilote.getNumeroPilote())) {
			try {
				int id = pilote.getNumeroPilote();
				String requete = "delete from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
				PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
				pst.setInt(1, id);
				pst.executeUpdate();
			} catch (Exception e) {
				succes = false;
				e.printStackTrace();
			}
		} else {
			System.out.println("Le pilote est présent sur un/des vol et ne peut pas être supprimé");
			succes = false;
		}
		return succes;
	}

	@Override
	public boolean update(Pilote pilote) {
		boolean succes = true;
		try {
			String requete = "update "+TABLE+" set nompil = ?, adr = ?, sal = ? where numpil= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(4, pilote.getNumeroPilote());
			pst.setString(1, pilote.getNomPilote());
			pst.setString(2, pilote.getAdresse());
			pst.setInt(3, pilote.getSalaire());

			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			succes = false;
			System.out.println("creation failed");
		}

		return succes;
	}

	@Override
	public Pilote find(int id) {
		Pilote pilote = new Pilote();
		try {
			String requete = "select * from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			res.next();
			pilote.setNumeroPilote(res.getInt(1));
			pilote.setNomPilote(res.getString(2));
			pilote.setAdresse(res.getString(3));
			pilote.setSalaire(res.getInt(4));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pilote;
	}

}
