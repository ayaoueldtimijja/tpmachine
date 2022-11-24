package tests;

import java.util.Date;
import java.util.Scanner;

import Entite.Client;
import Entite.Commande;
import Entite.Demande;
import Entite.Fournisseur;
import Entite.LigneCommande;
import Entite.LigneDemande;
import Entite.Produit;
import Entite.Rayon;
import Service.ClientService;
import Service.CommandeService;
import Service.DemandeService;
import Service.FournisseurService;
import Service.LigneCommandeService;
import Service.LigneDemandeService;
import Service.ProduitService;
import Service.RayonService;

public class Test {

	public static void main(String[] args) {
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		CommandeService ccs = new CommandeService();
		LigneCommandeService lcs = new LigneCommandeService();
		FournisseurService fs = new FournisseurService();
		RayonService rs = new RayonService();
		DemandeService ds = new DemandeService();
		LigneDemandeService lds = new LigneDemandeService();
		/*
		 * fs.create(new Fournisseur("Badr","0524446217")); ds.create(new
		 * Demande(fs.findById(1),new Date())); rs.create(new Rayon("254"));
		 */
		// cs.create(new Client("Aya","0624341518","aya@gmail.com"));
		// cs.create(new Client("Amina","0649012263","amina@gmail.com"));
		/*
		 * ps.create(new Produit("Dell",15000,rs.findById(1),10)); ps.create(new
		 * Produit("Lenovo",25000,rs.findById(1),15)); ps.create(new
		 * Produit("HP",20000,rs.findById(1),20));
		 */
		// ccs.create(new Commande(new Date(),cs.findById(1)));
		// ccs.create(new Commande(new Date(),cs.findById(2)));
		// ccs.create(new Commande(new Date(),cs.findById(2)));
		/*
		 * lcs.create(new LigneCommande(5,20000,ccs.findById(1),ps.findById(1)));
		 * lcs.create(new LigneCommande(5,30000,ccs.findById(2),ps.findById(2)));
		 * lcs.create(new LigneCommande(10,15000,ccs.findById(2),ps.findById(3)));
		 */
		Scanner sc2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int d = 0;
		while (d < 20) {
			System.out.println("------------------------------MENU--------------------------------\n");
			System.out.println("1-ajouter client ");
			System.out.println("2-rechercher client ");
			System.out.println("3-afficher les clients ");
			System.out.println("4-supprimer Client ");
			System.out.println("5-ajouter produit ");
			System.out.println("6-afficher les produits ");
			System.out.println("7-rechercher produit ");
			System.out.println("8-supprimer produit");
			System.out.println("9-rechercher les commandes faites par un client ");
			System.out.println("10-afficher toutes les commandes faites");
			System.out.println("11-faire une demande d'un produit");
			System.out.println("12-afficher toutes les demandes faites");
			System.out.println("13-ajouter un fournisseur");
			System.out.println("14-afficher les fournisseurs");
			System.out.println("15-Ajouter demande");
			System.out.println("16-Faire une commande");
			System.out.println("17-Supprimer Fournisseur");
			System.out.println("18-ajouter rayon ");
			System.out.println("19-ajouter commande");
			System.out.println("20-quitter");
			System.out.println("donnez votre choix ");
			d = sc2.nextInt();
			switch (d) {
			case 1: {
				System.out.println("donnez le nom du client ");
				String b = sc.nextLine();
				System.out.println("donnez le phone ");
				String tel = sc.nextLine();
				System.out.println("donnez l'email ");
				String em = sc.nextLine();
				cs.create(new Client(b, tel, em));
				System.out.println("Client ajoute ");
				break;
			}
			case 2: {
				int l = 0;
				System.out.println("Donnez le nom du client ");
				String n = sc.nextLine();
				for (Client c : cs.findAll()) {
					if (c.getNom().equals(n)) {
						System.out.println(c);
						l++;
					}
				}
				if (l == 0) {
					System.out.println("Aucun client n a le nom entre ");
				}
				break;
			}
			case 3: {
				for (Client c : cs.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 4: {
				int l = 0;
				System.out.println("Donnez le nom du client ");
				String n = sc.nextLine();
				for (Client c : cs.findAll()) {
					if (c.getNom().equals(n)) {
						cs.delete(c);
						l++;
						System.out.println("client supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun client n a le nom entre ");
				}
				break;
			}
			case 5: {
				Scanner sc6=new Scanner(System.in);
				Scanner sc7=new Scanner(System.in);
				System.out.println("Donnez la designation d'un produit ");
				String des = sc6.nextLine();
				System.out.println("Donnez le prix d'achat du produit ");
				Double pr = sc7.nextDouble();
				System.out.println("Choisissez votre rayon");
				for (Rayon r : rs.findAll()) {
					System.out.println(r);
				}
				int rc = sc.nextInt();
				System.out.println("donnez la quantite du produit");
				int qu = sc.nextInt();
				ps.create(new Produit(des, pr, rs.findById(rc), qu));
				System.out.println("produit ajoute");
				break;
			}
			case 6: {
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 7: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				for(Produit p:ps.findAll())
				{
					System.out.println(p);
				}
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						System.out.println(c);
						l++;
					}
				}
				if (l == 0) {
					System.out.println("Aucun produit n a le nom entre ");
				}
				break;
			}
			case 8: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						ps.delete(c);
						l++;
						System.out.println("produit supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun produit n a le nom entre ");
				}
				break;
			}
			case 9: {
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Donnez le nom du client");
				String d1 = sc3.nextLine();
				int k = 0;
				for (LigneCommande c : lcs.findAll()) {
					if ((c.getCommande().getClient().getNom()).equals(d1)) {
						System.out.println(c);
						k++;
					}

				}
				if (k == 0)
					System.out.println("nom entre non existant");
				break;
			}
			case 10: {
				System.out.println("Voici les Commandes Faites");
				for (LigneCommande c : lcs.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 11: {
				System.out.println("Donnez l'id du produit que vous voulez");
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}

				int g = sc.nextInt();
				System.out.println("donnez l'id de votre demande");
				for (Demande dem : ds.findAll()) {
					System.out.println(dem);
				}
				int de = sc.nextInt();
				System.out.println("Donnez la quantite dont vous avez besoin");
				int qu = sc.nextInt();
				lds.create(new LigneDemande(ps.findById(g), ds.findById(de), qu));
				System.out.println("Demande faite");
				break;
			}
			case 12: {
				System.out.println("Voici les Commandes Faites");
				for (LigneDemande c : lds.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 13: {
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Donnez le nom du fournisseur");
				String name = sc3.nextLine();
				System.out.println("Donnez son telephone");
				String phone = sc4.nextLine();
				fs.create(new Fournisseur(name, phone));
				System.out.println("Fournisseur ajoute");
				break;
			}
			case 14: {
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				break;
			}
			case 15: {
				System.out.println("donnez l'id du fournisseur");
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				int i = sc.nextInt();
				ds.create(new Demande(fs.findById(i), new Date()));
				System.out.println("Demande ajoute");
				break;
			}
			case 16: {
				Scanner sc10=new Scanner(System.in);
				System.out.println("Donnez l'id de la commande");
				for (Commande c : ccs.findAll()) {
					System.out.println(c);
				}
				int cmd = sc10.nextInt();
				System.out.println("Donnez l'id du produit");
				for (Produit p : ps.findAll()) {
					System.out.println(p);
				}
				int cl = sc.nextInt();
				System.out.println("Donnez la quantite ");
				int qu = sc.nextInt();
				System.out.println("Donnez le prix de vente");
				double pr = sc2.nextDouble();
				lcs.create(new LigneCommande(qu, pr, ccs.findById(cmd), ps.findById(cl)));
				System.out.println("Commande faite");
				break;
			}
			case 17: {
				int l = 0;
				System.out.println("Donnez l'id du fournisseur \n");
				for (Fournisseur c : fs.findAll()) {
					System.out.println(c);
				}
				int n = sc.nextInt();
				for (Fournisseur c : fs.findAll()) {
					if (c.getId() == n) {
						fs.delete(c);
						l++;
						System.out.println("fournisseur supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun fournisseur n a le nom entre \n");
				}
				break;
			}
			case 18:
			{
				Scanner sc5 = new Scanner(System.in);

				System.out.println("donnez le code du rayon");
				String cod = sc5.nextLine();
				rs.create(new Rayon(cod));
				System.out.println("rayon ajoute avec succes");
				break;

			}
			case 19:
			{
				Scanner sc9=new Scanner(System.in);
				System.out.println("Donnez l'id du client");
				for(Client c:cs.findAll())
				{
					System.out.println(c);
				}
				int vv=sc9.nextInt();
				ccs.create(new Commande(new Date(),cs.findById(vv)));
				System.out.println("commande ajoutee");
				break;
			}
			}
		}
	}
}
