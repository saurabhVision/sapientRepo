package com.sapient.assignment.sapientassignment.service;

import com.sapient.assignment.sapientassignment.exception.ProductNotFoundException;
import com.sapient.assignment.sapientassignment.model.ProductEntity;
import com.sapient.assignment.sapientassignment.model.ServiceResponse;
import com.sapient.assignment.sapientassignment.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueManagerImpl implements CatalogueManager{
	
	@Autowired
	CatalogueRepository catalogueRepository;
	

	@Override
	public List<ProductEntity> getProducts(String type) {
		List<ProductEntity> products;
		if (type != null){
			products  = catalogueRepository.findByProductType(type);
		}else{
			products = catalogueRepository.findAll();
		}
		
		if(products == null || products.isEmpty())
			throw new ProductNotFoundException("No products found!");
		
		return products;
	}

	@Override
	public ServiceResponse addProduct(ProductEntity product) {
		catalogueRepository.save(product);
		return new ServiceResponse("Successful","Product added successfully");
	}

	@Override
	public ProductEntity getProduct(Long id) {
		ProductEntity product  = catalogueRepository.findById(id);
		if(product == null)
			throw new ProductNotFoundException("Invalid product id!");

		return product;
	}

	@Override
	public ServiceResponse updateProduct(ProductEntity product) {
		catalogueRepository.save(product);
		return new ServiceResponse("Successful","Product updated successfully");
	}

	@Override
	public ServiceResponse deleteProduct(Long id) {
		ProductEntity product  = catalogueRepository.findById(id);
		if(product != null)
			catalogueRepository.delete(product);
		else
			throw new ProductNotFoundException("Invalid product id!");
		return new ServiceResponse("Successful","Product deleted successfully");
	}

}
