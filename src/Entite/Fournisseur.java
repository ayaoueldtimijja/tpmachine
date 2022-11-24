package Entite;

public class Fournisseur {

	private int id;
	private String name;
	private String telephone;
	private static int comp;

	public Fournisseur(String name, String telephone) {
		super();
		this.id = ++comp;
		this.name = name;
		this.telephone = telephone;
	}

	public Fournisseur(int id, String name, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Fournisseur id=" + id + ", name=" + name + ", telephone=" + telephone;
	}

}
