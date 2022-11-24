package Entite;

import java.util.Date;

public class Commande {

	private int id;
	private Date date;
	private Client client;
	private static int comp;

	public Commande(int id, Date date, Client client) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
	}

	public Commande(Date date, Client client) {
		this.id = ++comp;
		this.date = date;
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " \n id : " + id + ", date : " + date + "\n client : " + client;
	}

}
