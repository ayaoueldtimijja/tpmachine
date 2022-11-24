package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entite.Fournisseur;
import Entite.LigneCommande;
import Entite.Produit;
import connexion.connexion;
import dao.IDAO;

public class LigneCommandeService implements IDAO<LigneCommande> {

	private ProduitService ps;
	private CommandeService cs;

	public LigneCommandeService() {
		ps = new ProduitService();
		cs = new CommandeService();
	}

	@Override
	public boolean create(LigneCommande o) {
		try {
			String sql = "insert into lignecommande values(null," + o.getQuantite() + "," + o.getPrixVente() + ","
					+ o.getCommande().getId() + "," + o.getProduit().getId() + ")";
			String sql3="delete from commande where id="+o.getCommande().getId();
			Statement st3=connexion.getConnection().createStatement();
			st3.executeUpdate(sql3);
			Produit p=ps.findById(o.getProduit().getId());
			if(p!=null)
			{
			p.quantite=p.quantite-o.getQuantite();
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
	public boolean delete(LigneCommande o) {
		try {
			String sql = "delete from lignecommande where id=" + o.getId();
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
	public boolean update(LigneCommande o) {
		try {
			String sql = "update lignecommande set quantite=" + o.getQuantite() + ",prixVente=" + o.getPrixVente()
					+ ",commande=" + o.getCommande().getId() + ",produit=" + o.getProduit().getId();
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
	public LigneCommande findById(int id) {
		try {
			String sql = "select *from lignecommande where id=" + id;
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				return new LigneCommande(rs.getInt("id"), rs.getInt("quantite"), rs.getDouble("prixVente"),
						cs.findById(rs.getInt("commande")), ps.findById(rs.getInt("produit")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LigneCommande> findAll() {
		List<LigneCommande> lignecommandes;
		try {

			lignecommandes = new ArrayList<LigneCommande>();
			String sql = "select * from lignecommande";
			Statement st = connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				lignecommandes.add(new LigneCommande(rs.getInt("id"), rs.getInt("quantite"), rs.getDouble("prixVente"),
						cs.findById(rs.getInt("commande")), ps.findById(rs.getInt("produit"))));
			}
			return lignecommandes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
