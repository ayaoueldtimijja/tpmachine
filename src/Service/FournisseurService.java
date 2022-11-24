package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Fournisseur;
import connexion.connexion;
import dao.IDAO;

public class FournisseurService implements IDAO<Fournisseur> {

	@Override
	public boolean create(Fournisseur o) {
		try {
			String sql = "insert into fournisseur values(null,'" + o.getName() + "','" + o.getTelephone() + "')";
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
	public boolean delete(Fournisseur o) {
		try {
			String sql = "delete from fournisseur where id=" + o.getId();
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
	public boolean update(Fournisseur o) {
		try {
			String sql = "update fournisseur set name='" + o.getName() + "',telephone='" + o.getTelephone() + "'";
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
	public Fournisseur findById(int id) {
		try {
			String sql = "select *from fournisseur where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Fournisseur(rs.getInt("id"), rs.getString("name"), rs.getString("telephone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs;
		try {

			fournisseurs = new ArrayList<Fournisseur>();
			String sql = "select * from fournisseur";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				fournisseurs.add(new Fournisseur(rs.getInt("id"), rs.getString("name"), rs.getString("telephone")));
			}
			return fournisseurs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
