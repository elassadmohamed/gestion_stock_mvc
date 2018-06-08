package com.stock.mvc.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommandeClient implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Long idLigneCdeClt;
	
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idCommandeClient")
	private CommandeClient commandeClient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUniaitre;
	
	
	public Long getIdLigneCdeClt() {
		return idLigneCdeClt;
	}

	public void setIdLigneCdeClt(Long id) {
		this.idLigneCdeClt = id;
	}
	
	@JsonIgnore
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	@JsonIgnore
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUniaitre() {
		return prixUniaitre;
	}

	public void setPrixUniaitre(BigDecimal prixUniaitre) {
		this.prixUniaitre = prixUniaitre;
	}



	
	
	
}