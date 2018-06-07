package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Category;
import com.stock.mvc.entities.Client;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.ICategoryService;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value="/")
	public String article(Model model){
		List<Article> lArticles=articleService.selectAll();
		
		if(lArticles==null){
			lArticles=new ArrayList<Article>();
		}
		
		model.addAttribute("articles",lArticles);
	
		return"article/article";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterArticle(Model model) {
		Article article=new Article();
		article.setDesignation("J3");
		List<Category> lCategories=categoryService.selectAll();
		model.addAttribute("article", article);
		model.addAttribute("categories",lCategories);
		return "article/ajouterArticle";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerArticle(Model model, Article article)  {
		String photoUrl = null;
		if (article != null) {		
			if(article.getIdArticle()!=null){
				articleService.update(article);
			}else{
				articleService.save(article);
			}
		}
		return "redirect:/article/";
	}
	
	@RequestMapping(value="/modifier/{idArticle}")
	public String modifierClient(Model model,@PathVariable Long idArticle){
		if(idArticle!=null){
			Article article=articleService.getById(idArticle);
			if(article!=null){
				model. addAttribute("article",article);
				articleService.update(article);
			}
		}
		return "article/ajouterArticle";
	}
	
	
	@RequestMapping(value="/supprimer/{idArticle}")
	public String supprimerClient(Model model,@PathVariable Long idArticle){
		if(idArticle!=null){
			Article article=articleService.getById(idArticle);
			if(article!=null){
				//model. addAttribute("client",client);
				articleService.remove(idArticle);
			}
		}
		return "redirect:/article/";
	}
}
