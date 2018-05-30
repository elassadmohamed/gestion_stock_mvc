package com.stock.mvc.dao.impl;

import org.springframework.beans.factory.InitializingBean;

import com.stock.mvc.dao.IArticleDao;
import com.stock.mvc.entities.Article;

public class ArticleDaoImpl extends GenericDaoImpl<Article> implements IArticleDao,InitializingBean{
	public void initIt(){
		System.out.println("################ INITIALISATION ArticleDaoImpl");
	}
	
	public void cleanUp(){
		System.out.println("################ DESTROY ArticleDaoImpl");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("################ INITIALISATION ArticleDaoImpl afterPropertiesSet");
		
	}
}
