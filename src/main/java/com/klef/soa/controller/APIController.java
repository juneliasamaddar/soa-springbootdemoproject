package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.dto.ProductDTO;
import com.klef.soa.service.APIService;

@RestController
@RequestMapping("/product")
public class APIController 
{
	@Autowired
	private APIService service;
	
	@GetMapping("/displayall")
	public List<ProductDTO> displayallproducts()
	{
		return service.displayAllProducts();
	}
	
	@GetMapping("/display/{id}")
	public ProductDTO displayproductbyid(@PathVariable int id)
	{
		return service.displayProductById(id);
	}
}
