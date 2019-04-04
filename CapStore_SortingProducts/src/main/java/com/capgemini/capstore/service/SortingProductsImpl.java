package com.capgemini.capstore.service;

import java.util.ArrayList;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.dao.SortingProductsDAOInterface;

@Service
public class SortingProductsImpl implements SortingProducts {

	@Autowired
	SortingProductsDAOInterface sortingProductsDao;
	
	public SortingProductsImpl(SortingProductsDAOInterface sortingProductsDao) {
		super();
		this.sortingProductsDao = sortingProductsDao;
	}

	public SortingProductsImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> sortProductsByRange(Double max, Double min) {
		List<Product> allProducts= sortingProductsDao.findAll();
		List<Product> result = new ArrayList<>();
		for(Product product:allProducts)
		{
			if(product.getProductPrice()>min && product.getProductPrice()<=max)
			{
				result.add(product);
			}
		}
		return result;
	}
	
	@Override
	public List<Product> sortProductsByPriceLowToHigh() {
		List<Product> allProducts= sortingProductsDao.findAll();
		List<Product> result = new ArrayList<>();
		List<Double> prices = new ArrayList<>();
		for(Product product:allProducts)
		{
			prices.add(product.getProductPrice());
		}
		Collections.sort(prices);
		for(Double price:prices)
		{
			for(Product product:allProducts)
			{
				if((Double.compare(price, product.getProductPrice())) == 0)
				{
					result.add(product);
				}
			}
		}
		return result;
	}

	@Override
	public List<Product> sortProductsByPriceHighToLow() {
		List<Product> allProducts= sortingProductsDao.findAll();
		List<Product> result = new ArrayList<>();
		List<Double> prices = new ArrayList<>();
		for(Product product:allProducts)
		{
			prices.add(product.getProductPrice());
		}
		Collections.sort(prices);
		Collections.reverse(prices);
		for(Double price:prices)
		{
			for(Product product:allProducts)
			{
				if((Double.compare(price, product.getProductPrice())) == 0)
				{
					result.add(product);
				}
			}
		}
		return result;
	}

	

}
