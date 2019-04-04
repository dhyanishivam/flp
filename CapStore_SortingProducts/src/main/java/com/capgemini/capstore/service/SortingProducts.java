package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Product;

@Service
public interface SortingProducts {
	
	List<Product> sortProductsByPriceLowToHigh();
	List<Product> sortProductsByPriceHighToLow();
	List<Product> sortProductsByRange(Double max, Double min); 

}
