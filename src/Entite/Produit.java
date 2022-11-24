package Entite;

public class Produit {

	private int id;
	private String designation;
	private double prixAchat;
	public int quantite;
	private static int comp;
	private Rayon rayon;

	public Produit(String designation, double prixAchat, Rayon rayon, int quantite) {
		this.id = ++comp;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.quantite = quantite;
		this.rayon = rayon;
	}

	public Produit(int id, String designation, double prixAchat, int quantite, Rayon rayon) {
		super();
		this.id = id;
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.quantite = quantite;
		this.rayon = rayon;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	@Override
	public String toString() {
		return " \n id : " + id + ", designation : " + designation + ", prixAchat : " + prixAchat + ", rayon :" + rayon
				+ " ,quantite :" + quantite;
	}

}
