package fr.epsi.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
public class Commande  implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idCommande;
	private Date date;
	private double montant;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinTable(name="CommandeProduit",
				joinColumns = @JoinColumn(name = "idCommande"),
				inverseJoinColumns = @JoinColumn (name = "idProduit"))
	private Collection<Produit> produits;
	
	
	
	
	
	//getters & setters
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits2) {
		this.produits = produits2;
		
	}
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	//constructeurs
	public Commande() {
		
		super();
		
	}
	public Commande(Long idCommande, Date date, double montant, Collection<Produit> produits , Client client) {
		setIdCommande(idCommande);
		setDate(date);
		setMontant(montant);
		setProduits(produits);
		setClient(client);
	}
	
	
	
	

}
