package com.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CommandeClient implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Long idCommandeClient;
	private String code;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany(mappedBy="commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
	
	@Transient
	private BigDecimal totalCommande;
	


	public Long getIdCommandeClient() {
		return idCommandeClient;
	}

	public void setIdCommandeClient(Long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	@JsonIgnore
	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(
			List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}
	
	
	public BigDecimal getTotalCommande(){
		if(!ligneCommandeClients.isEmpty()){
			for(LigneCommandeClient ligneCommandeClient:ligneCommandeClients){
				BigDecimal totalLigne=ligneCommandeClient.getQuantite().multiply(ligneCommandeClient.getPrixUniaitre());
				totalCommande=totalCommande.add(totalLigne);
			}
		}
		return totalCommande;
	}
	
}