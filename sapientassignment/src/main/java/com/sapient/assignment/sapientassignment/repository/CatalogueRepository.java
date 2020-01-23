package com.sapient.assignment.sapientassignment.repository;

import com.sapient.assignment.sapientassignment.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueRepository extends JpaRepository<ProductEntity, String> {

	List<ProductEntity> findByProductType(String type);

	ProductEntity findById(Long id);

}