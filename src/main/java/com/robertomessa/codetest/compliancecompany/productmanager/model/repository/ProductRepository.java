package com.robertomessa.codetest.compliancecompany.productmanager.model.repository;

import com.robertomessa.codetest.compliancecompany.productmanager.model.CategoryEntity;
import com.robertomessa.codetest.compliancecompany.productmanager.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
