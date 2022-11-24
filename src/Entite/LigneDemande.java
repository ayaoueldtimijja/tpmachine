package Entite;

public class LigneDemande {

	private int id;
	private Produit produit;
	private Demande demande;
	private int quantite;
	private static int comp;

	public LigneDemande(Produit produit, Demande demande, int quantite) {
		super();
		this.id = ++comp;
		this.produit = produit;
		this.demande = demande;
		this.quantite = quantite;
		this.produit.quantite = this.produit.quantite + this.quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LigneDemande(int id, Produit produit, Demande demande, int quantite) {
		super();
		this.id = id;
		this.produit = produit;
		this.demande = demande;
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	@Override
	public String toString() {
		return "LigneDemande id=" + id + ", produit=" + produit.getDesignation()+" quantite:"+quantite + ", demande=" + demande ;
	}

}
