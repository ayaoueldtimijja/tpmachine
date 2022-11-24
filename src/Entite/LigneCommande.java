package Entite;

public class LigneCommande {
	private int id;
	private int quantite;
	private double prixVente;
	private Commande commande;
	private Produit produit;
	private static int comp;

	
	public LigneCommande(int quantite, double prixVente, Commande commande, Produit produit) {
		this.id = ++comp;
		this.quantite = quantite;
		this.prixVente = prixVente;
		this.commande = commande;
		this.produit = produit;
		this.produit.quantite = this.produit.quantite - this.quantite;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LigneCommande(int id, int quantite, double prixVente, Commande commande, Produit produit) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixVente = prixVente;
		this.commande = commande;
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return " commande : " + commande + "\n produit :" + produit.getDesignation() + " quantite : " + quantite + " prixVente : "
				+ prixVente + "\n ";
	}

}
