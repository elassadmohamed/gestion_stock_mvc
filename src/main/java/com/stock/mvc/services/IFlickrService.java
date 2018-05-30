package com.stock.mvc.services;

import java.io.InputStream;

public interface IFlickrService {
	public String savePhoto(InputStream stream,String fileName) throws Exception;
}
