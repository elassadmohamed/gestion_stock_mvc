package com.stock.mvc.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Client;
import com.stock.mvc.entities.CommandeClient;
import com.stock.mvc.entities.LigneCommandeClient;

@Component
public class ModelCommandeClientImpl implements ModelCommandeClient{

	private CommandeClient commande;
	private Map<Long,LigneCommandeClient> ligneCde=new HashMap<Long,LigneCommandeClient>();
	
	
	@Override
	public void creerCommande(Client client) {
		if(client==null){
			return;
		}
		commande=new CommandeClient();
		commande.setClient(client);
		commande.setDateCommande(new Date());
		commande.setCode("");		
	}

	@Override
	public LigneCommandeClient ajouterLigneCommande(Article article) {
		if(article==null){
		return null;
		}
		LigneCommandeClient lc=ligneCde.get(article.getIdArticle());
		if(lc!=null){
			BigDecimal qte=lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			ligneCde.put(article.getIdArticle(),lc);
		}else{
			LigneCommandeClient ligne=new LigneCommandeClient();
			ligne.setCommandeClient(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUniaitre(article.getPrixUnitaireHT());
			ligne.setArticle(article);
			ligneCde.put(article.getIdArticle(),ligne);
			return ligne;
		}
		return null;
	}

	@Override
	public LigneCommandeClient supprimerLigneCommande(Article article) {
		if(article==null){
			return null;
		}
		return ligneCde.remove(article.getIdArticle());
	}

	@Override
	public LigneCommandeClient modifierQuantite(Article article, double qte) {
		if(article==null){
			return null;
		}
		LigneCommandeClient lc=ligneCde.get(article.getIdArticle());
		if(lc==null){
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(qte));
		return lc;
	}

	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public CommandeClient getCommande() {
		return commande;
	}

	public void setCommande(CommandeClient commande) {
		this.commande = commande;
	}

	public Map<Long, LigneCommandeClient> getLigneCde() {
		return ligneCde;
	}

	public void setLigneCde(Map<Long, LigneCommandeClient> ligneCde) {
		this.ligneCde = ligneCde;
	}

}
