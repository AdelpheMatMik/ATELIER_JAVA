package fr.epsi.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
public class Produit implements Serializable {
	
	
	@Id()
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idProduit;
	private String nom;
	private double prix;
	
	@ManyToOne
	@JoinTable(name="CommandeProduit",
				joinColumns = @JoinColumn(name = "idProduit"),
				inverseJoinColumns = @JoinColumn (name = "idCommande"))
	private Collection<Commande> commande;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Produit() {
	
	}
	public Produit(Long idProduit, String nom, double prix) {
		setIdProduit(idProduit);
		setNom(nom);
		setPrix(prix);
	}
	
	
	
	
	
	

}
