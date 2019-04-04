package com.capgemini.capstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.service.SortingProducts;

@RestController
public class SortingProductsController {

	@Autowired
	SortingProducts service;
	
	@RequestMapping(value="/sortByRange/{max}/{min}", method=RequestMethod.GET)
	public List<Product> sortByRange(@Valid @PathVariable Double max, @Valid @PathVariable Double min)
	{
		return service.sortProductsByRange(max, min);
	}
	
	@RequestMapping(value="/lowToHigh", method=RequestMethod.GET)
	public List<Product> lowToHigh()
	{
		return service.sortProductsByPriceLowToHigh();
	}
	
	@RequestMapping(value="/HighToLow", method=RequestMethod.GET)
	public List<Product> HighToLow()
	{
		return service.sortProductsByPriceHighToLow();
	}
}
