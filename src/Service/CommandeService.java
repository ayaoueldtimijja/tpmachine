package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entite.Client;
import Entite.Commande;
import connexion.connexion;
import dao.IDAO;

public class CommandeService implements IDAO<Commande> {

	ClientService cs;

	public CommandeService() {
		cs = new ClientService();
	}

	@Override
	public boolean create(Commande o) {
		try {
			String sql = "insert into commande values(null,'" + new java.sql.Date(o.getDate().getTime()) + "','"
					+ o.getClient().getId() + "')";
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Commande o) {
		try {
			String sql = "delete from commande where id=" + o.getId();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Commande o) {
		try {
			String sql = "update commande set date='" + o.getDate().getTime() + "',client=" + o.getClient().getId();
			Statement st = connexion.getConnection().createStatement();
			if (st.executeUpdate(sql) == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Commande findById(int id) {
		try {
			String sql = "select * from commande where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				return new Commande(rs.getInt("id"), rs.getDate("date"), cs.findById(rs.getInt("client")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes;
		try {
			commandes = new ArrayList<Commande>();
			String sql = "select * from commande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				commandes.add(new Commande(rs.getInt("id"), rs.getDate("date"), cs.findById(rs.getInt("client"))));
			}
			return commandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
