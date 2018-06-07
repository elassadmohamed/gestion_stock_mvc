package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.mvc.entities.CommandeClient;
import com.stock.mvc.entities.LigneCommandeClient;
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
	
}
