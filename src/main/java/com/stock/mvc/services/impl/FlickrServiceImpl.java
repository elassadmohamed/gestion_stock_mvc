package com.stock.mvc.services.impl;

import java.io.InputStream;

import com.stock.mvc.dao.IFlickrDao;
import com.stock.mvc.services.IFlickrService;

public class FlickrServiceImpl implements IFlickrService{
	/*
	* The daoFlickr
	*/
	private IFlickrDao dao;
	
	
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}



	@Override
	public String savePhoto(InputStream stream, String fileName)
			throws Exception {
		return dao.savePhoto(stream, fileName);
	}

}
