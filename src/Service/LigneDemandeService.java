package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.LigneCommande;
import Entite.LigneDemande;
import Entite.Produit;
import connexion.connexion;
import dao.IDAO;

public class LigneDemandeService implements IDAO<LigneDemande> {

	private DemandeService ds;
	private ProduitService ps;

	public LigneDemandeService() {
		ds = new DemandeService();
		ps = new ProduitService();
	}

	@Override
	public boolean create(LigneDemande o) {
		try {
			String sql = "insert into lignedemande values(null," + o.getProduit().getId() + "," + o.getDemande().getId()
					+ "," + o.getQuantite() + ")";
			Produit p=ps.findById(o.getProduit().getId());
			String sql3="delete from demande where id="+o.getDemande().getId();
			Statement st3=connexion.getConnection().createStatement();
			st3.executeUpdate(sql3);
			if(p!=null)
			{
			p.quantite=p.quantite+o.getQuantite();
			String sql2="update produit set quantite="+p.quantite +" where id="+o.getProduit().getId();
			Statement st2=connexion.getConnection().createStatement();
			st2.executeUpdate(sql2);
			}
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
	public boolean delete(LigneDemande o) {
		try {
			String sql = "delete from lignedemande where id=" + o.getId();
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
	public boolean update(LigneDemande o) {
		try {
			String sql = "update lignedemande set produit=" + o.getProduit().getId() + ",demande="
					+ o.getDemande().getId() + ",quantite=" + o.getQuantite();
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
	public LigneDemande findById(int id) {
		try {
			String sql = "select *from lignedemande where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new LigneDemande(rs.getInt("id"), ps.findById(rs.getInt("produit")),
						ds.findById(rs.getInt("demande")), rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LigneDemande> findAll() {
		List<LigneDemande> lignedemandes;
		try {

			lignedemandes = new ArrayList<LigneDemande>();
			String sql = "select * from lignedemande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				lignedemandes.add(new LigneDemande(rs.getInt("id"), ps.findById(rs.getInt("produit")),
						ds.findById(rs.getInt("demande")), rs.getInt("quantite")));
			}
			return lignedemandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
