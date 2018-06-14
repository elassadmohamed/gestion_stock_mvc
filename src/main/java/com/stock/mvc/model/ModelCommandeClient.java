package com.stock.mvc.model;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Client;
import com.stock.mvc.entities.LigneCommandeClient;

public interface ModelCommandeClient {
	void creerCommande(Client client);
	LigneCommandeClient ajouterLigneCommande(Article article);
	LigneCommandeClient supprimerLigneCommande(Article article);
	LigneCommandeClient modifierQuantite(Article article,double qte);
	String generateCodeCommande();
	
}
