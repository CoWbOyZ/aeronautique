package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Vol;

public class VolDAO extends DAO<Vol>{

	private static final String TABLE = "vol";
	private static final String CLE_PRIMAIRE = "numvol";

	private boolean isFreeToCreate(int numpil, int numav){
		boolean test = true;
		try {
			ResultSet resPilote = Connexion.executeQuery("select numpil from pilote where numpil = "+numpil);
			ResultSet resAvion = Connexion.executeQuery("select numav from avion where numav = "+numav);
			test = resPilote.next() && resAvion.next();
		} catch (SQLException e) {
			System.out.println("echec de la tentative d'interrogation : "+e.getMessage());
		}
		return test;
	}

	@Override
	public boolean create(Vol vol) {
		boolean succes = true;
		if (isFreeToCreate(vol.getNumeroPilote(), vol.getNumeroAvion())) {
			try {
				String requete = "insert into "+TABLE+" (numpil, numav, ville_dep, ville_arr, h_dep, h_arr) values (?,?,?,?,?,?)";
				PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
				pst.setInt(1, vol.getNumeroPilote());
				pst.setInt(2, vol.getNumeroAvion());
				pst.setString(3, vol.getVilleDepart());
				pst.setString(4, vol.getVilleArrivee());
				pst.setTimestamp(5, vol.getHeureDepart());
				pst.setTimestamp(6, vol.getHeureArrivee());
				pst.executeUpdate();

				vol.setNumeroVol((Connexion.getMaxId(CLE_PRIMAIRE, TABLE)));

			} catch (Exception e) {
				e.printStackTrace();
				succes = false;
				System.out.println("creation failed");
			}
		} else {
			System.out.println("Le vol ne peut pas être créé car il manque le pilote ou l'avion est inexistant");
			succes = false;
		}


		return succes;
	}

	@Override
	public boolean delete(Vol vol) {
		boolean succes = true;
		try {
			int id = vol.getNumeroVol();
			String requete = "delete from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			succes = false;
			e.printStackTrace();
		}

		return succes;
	}

	@Override
	public boolean update(Vol vol) {
		boolean succes = true;
		try {
			String requete = "update "+TABLE+" set numpil = ?, numav = ?, ville_dep = ?, ville_arr = ?, h_dep = ?, h_arr = ? where numvol= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, vol.getNumeroPilote());
			pst.setInt(2, vol.getNumeroAvion());
			pst.setString(3, vol.getVilleDepart());
			pst.setString(4, vol.getVilleArrivee());
			pst.setTimestamp(5, vol.getHeureDepart());
			pst.setTimestamp(6, vol.getHeureArrivee());
			pst.setInt(7, vol.getNumeroVol());
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			succes = false;
			System.out.println("creation failed");
		}

		return succes;
	}

	@Override
	public Vol find(int id) {
		Vol vol = new Vol();
		try {
			String requete = "select * from "+TABLE+" where "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			//ResultSet res = Connexion.executeQuery(pst);
			res.next();
			vol.setNumeroVol(res.getInt(1));
			vol.setNumeroPilote(res.getInt(2));
			vol.setNumeroAvion(res.getInt(3));
			vol.setVilleDepart(res.getString(4));
			vol.setVilleArrivee(res.getString(5));
			vol.setHeureDepart(res.getTimestamp(6));
			vol.setHeureArrivee(res.getTimestamp(7));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vol;
	}

}
