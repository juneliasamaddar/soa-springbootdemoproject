package com.klef.soa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.klef.soa.dto.ProductDTO;

@Service
public class APIServiceImpl implements APIService
{
	@Autowired
	private RestTemplate template;
	private String apiurl="https://fakestoreapi.com/products";

	@Override
	public List<ProductDTO> displayAllProducts() {
		// TODO Auto-generated method stub
		//Object[] data = template.getForObject(apiurl, Object[].class);
		ProductDTO[] data = template.getForObject(apiurl, ProductDTO[].class);
		return Arrays.asList(data);
	}

	@Override
	public ProductDTO displayProductById(int id) {
		// TODO Auto-generated method stub
		return template.getForObject(apiurl+"/"+id, ProductDTO.class);
	}
	
}
