package com.sapient.assignment.sapientassignment.service;


import com.sapient.assignment.sapientassignment.model.ProductEntity;
import com.sapient.assignment.sapientassignment.model.ServiceResponse;

import java.util.List;

public interface CatalogueManager {

	List<ProductEntity> getProducts(String type);

	ServiceResponse addProduct(ProductEntity product);

	ProductEntity getProduct(Long id);

	ServiceResponse updateProduct(ProductEntity product);

	ServiceResponse deleteProduct(Long id);

}
