package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Rayon;
import connexion.connexion;
import dao.IDAO;

public class RayonService implements IDAO<Rayon> {
	@Override

	public boolean create(Rayon o) {
		try {
			String sql = "insert into rayon values(null,'" + o.getCode() + "')";
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
	public boolean delete(Rayon o) {
		try {
			String sql = "delete from rayon where id=" + o.getId();
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
	public boolean update(Rayon o) {
		try {
			String sql = "update rayon set code='" + o.getCode() + "'";
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
	public Rayon findById(int id) {

		try {
			String sql = "select * from rayon where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new Rayon(rs.getInt("id"), rs.getString("code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Rayon> findAll() {
		List<Rayon> rayons;
		try {
			rayons = new ArrayList<Rayon>();
			String sql = "select * from rayon";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				rayons.add(new Rayon(rs.getInt("id"), rs.getString("code")));
			}
			return rayons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
