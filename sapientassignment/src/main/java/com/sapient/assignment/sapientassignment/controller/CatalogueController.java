package com.sapient.assignment.sapientassignment.controller;

import com.sapient.assignment.sapientassignment.model.ProductEntity;
import com.sapient.assignment.sapientassignment.model.ServiceResponse;
import com.sapient.assignment.sapientassignment.service.CatalogueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogue")
public class CatalogueController {
	
	@Autowired
	CatalogueManager catalogueManager;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductEntity>> getProducts(@RequestParam(value="type", required=false) String type){
		List<ProductEntity> products = catalogueManager.getProducts(type);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ServiceResponse> addProduct(@RequestBody ProductEntity product){
		ServiceResponse serviceResponse = catalogueManager.addProduct(product);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id){
		ProductEntity product = catalogueManager.getProduct(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ServiceResponse> updateProduct(@RequestBody ProductEntity product){
		ServiceResponse serviceResponse = catalogueManager.updateProduct(product);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResponse> deleteProduct(@PathVariable Long id){
		ServiceResponse serviceResponse = catalogueManager.deleteProduct(id);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	

}
