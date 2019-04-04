package com.capgemini.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.capgemini.capstore.beans.Product;

@Transactional
@Configuration
@EnableTransactionManagement
@Repository
public interface SortingProductsDAOInterface extends JpaRepository<Product, String>{
	
	@Query(value="select * from productdetail",nativeQuery=true)
	public List<Product> findAll();

}
