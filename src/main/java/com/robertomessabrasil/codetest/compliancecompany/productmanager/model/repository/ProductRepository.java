package com.robertomessabrasil.codetest.compliancecompany.productmanager.model.repository;

import com.robertomessabrasil.codetest.compliancecompany.productmanager.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
