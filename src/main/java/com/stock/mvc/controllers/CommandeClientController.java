package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Client;
import com.stock.mvc.entities.CommandeClient;
import com.stock.mvc.entities.LigneCommandeClient;
import com.stock.mvc.model.ModelCommandeClient;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.IClientService;
import com.stock.mvc.services.ICommandeClientService;
import com.stock.mvc.services.ILigneCommandeClientService;

@Controller
@RequestMapping(value="/commandeClient")
public class CommandeClientController {

	@Autowired
	private ICommandeClientService commandeService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ILigneCommandeClientService ligneCdeService;
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ModelCommandeClient modelCommande;
	
	
	@RequestMapping(value="/")
	public String index(Model model){
		List<CommandeClient> commandesClient=commandeService.selectAll();
		if(commandesClient.isEmpty()){
			commandesClient=new ArrayList<CommandeClient>();
		}else{
			for(CommandeClient commandeClient:commandesClient){
				List<LigneCommandeClient> ligneCdeClt=ligneCdeService.getByIdCommande(commandeClient.getIdCommandeClient());
				commandeClient.setLigneCommandeClients(ligneCdeClt);
			}
		}
		model.addAttribute("commandesClient",commandesClient);
		
		return "commandeClient/commandeclient";
	}
	
	@RequestMapping(value="/nouveau")
	public String nouvelleCommande(Model model){
		List<Client> clients=clientService.selectAll();
		if(clients.isEmpty()){
			clients=new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		model.addAttribute("codeCde",modelCommande.generateCodeCommande());
		model.addAttribute("dateCde",new Date());
		return "commandeClient/nouvellecommande";
	}
	
	@RequestMapping(value="/detailArticle") 
	@ResponseBody
	public Article getArticleByCode(@RequestParam("codeArticle") final Long codeArticle){
		System.out.println("###"+codeArticle);
		if(codeArticle==null){
			return null;
		}
		//Article article=articleService.getById(codeArticle);
		Article article=articleService.findOne("codeArticle",""+codeArticle);
		if(article==null){
			return  null;
		}
		return article;
	}
	
}
