package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.entities.Client;
import com.stock.mvc.services.IClientService;
import com.stock.mvc.services.IFlickrService;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
	private static Logger logger = Logger.getLogger(ClientController.class);
	
	/*The clientService*/
	@Autowired
	private IClientService clientService;

	/*The flickService*/
	@Autowired
	private IFlickrService flickService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		logger.debug("msg de debogage");
		logger.info("msg d'information");
		logger.warn("msg d'avertissement");
		logger.error("msg d'erreur");
		logger.fatal("msg d'erreur fatale");
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "client/client";
	}

	//Afficher la page de saisit du nouveau client	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		
		Client client = new Client();
		client.setNom("Mohamed");
		model.addAttribute("client", client);
		return "client/ajouterClient";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(Model model, Client client,
			MultipartFile file)  {
		String photoUrl = null;
		if (client != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream=null;
				try{
					stream = file.getInputStream();
					photoUrl = flickService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try {
						stream.close();
					} catch (IOException e) { 
						e.printStackTrace();
					}
				}
			}
			
			if(client.getIdClient()!=null){
				clientService.update(client);
			}else{
				clientService.save(client);
			}
			
		}
		return "redirect:/client/";
	}
	
	@RequestMapping(value="/modifier/{idClient}")
	public String modifierClient(Model model,@PathVariable Long idClient){
		if(idClient!=null){
			Client client=clientService.getById(idClient);
			if(client!=null){
				//model. addAttribute("client",client);
				clientService.update(client);
			}
		}
		return "client/ajouterClient";
	}
	
	@RequestMapping(value="/supprimer/{idClient}")
	public String supprimerClient(Model model,@PathVariable Long idClient){
		if(idClient!=null){
			Client client=clientService.getById(idClient);
			if(client !=null){
				clientService.remove(idClient);
			}
		}
		return "redirect:/client/";
	}
}
