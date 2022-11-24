package Entite;

import java.util.Date;

public class Demande {

	private int id;
	private Fournisseur fournisseur;
	private Date date;
	private static int comp;

	public Demande(Fournisseur fournisseur, Date date) {
		super();
		this.id = ++comp;
		this.fournisseur = fournisseur;
		this.date = date;
	}

	public Demande(int id, Fournisseur fournisseur, Date date) {
		super();
		this.id = id;
		this.fournisseur = fournisseur;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Demande id=" + id + ", fournisseur=" + fournisseur + ", date=" + date;
	}

}
