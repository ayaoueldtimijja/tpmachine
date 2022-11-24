package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entite.Demande;
import connexion.connexion;
import dao.IDAO;

public class DemandeService implements IDAO<Demande> {

	FournisseurService fs;

	public DemandeService() {
		fs = new FournisseurService();
	}

	@Override
	public boolean create(Demande o) {
		try {
			String sql = "insert into demande values(null,'" + o.getFournisseur().getId() + "','"
					+ new java.sql.Date(o.getDate().getTime()) + "')";
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Demande o) {
		try {
			String sql = "delete from demande where id=" + o.getId();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean update(Demande o) {
		try {
			String sql = "update demande set fournisseur=" + o.getFournisseur().getId() + ",date="
					+ o.getDate().getTime();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Demande findById(int id) {

		try {
			String sql = "select * from demande where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Demande(rs.getInt("id"), fs.findById(rs.getInt("fournisseur")), rs.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Demande> findAll() {
		List<Demande> demandes;
		try {
			demandes = new ArrayList<Demande>();
			String sql = "select * from demande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				demandes.add(new Demande(rs.getInt("id"), fs.findById(rs.getInt("fournisseur")), rs.getDate("date")));
			}
			return demandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
