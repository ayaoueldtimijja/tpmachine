package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Produit;
import connexion.connexion;
import dao.IDAO;

public class ProduitService implements IDAO<Produit> {

	private RayonService rss;

	public ProduitService() {
		rss = new RayonService();
	}

	@Override
	public boolean create(Produit o) {
		try {
			String sql = "insert into produit values(null,'" + o.getDesignation() + "'," + o.getPrixAchat() + ","
					+ o.getQuantite() + "," + o.getRayon().getId() + ")";
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
	public boolean delete(Produit o) {
		try {
			String sql = "delete from produit where id=" + o.getId();
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
	public boolean update(Produit o) {
		try {
			String sql = "update produit set designation='" + o.getDesignation() + "',prixAchat=" + o.getPrixAchat()
					+ ",quantite=" + o.getQuantite() + ",rayon=" + o.getRayon().getId();
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
	public Produit findById(int id) {
		try {
			String sql = "select * from produit where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits;
		try {
			produits = new ArrayList<Produit>();
			String sql = "select * from produit";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				produits.add(new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"),
						rs.getInt("quantite"), rss.findById(rs.getInt("rayon"))));
			}
			return produits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
