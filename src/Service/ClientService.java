package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Client;
import connexion.connexion;
import dao.IDAO;

public class ClientService implements IDAO<Client> {

	@Override
	public boolean create(Client o) {
		try {
			String sql = "insert into client values(null,'" + o.getNom() + "','" + o.getTelephone() + "','"
					+ o.getEmail() + "')";
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
	public boolean delete(Client o) {
		try {
			String sql = "delete from client where id=" + o.getId();
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
	public boolean update(Client o) {
		try {
			String sql = "update client set nom='" + o.getNom() + "',telephone='" + o.getTelephone() + "',email='"
					+ o.getEmail() + "')";
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
	public Client findById(int id) {
		try {
			Client cl = null;
			String sql = "select * from client where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try {

			String sql = "select * from client";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
