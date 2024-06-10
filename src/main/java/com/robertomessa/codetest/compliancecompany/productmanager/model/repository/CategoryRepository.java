package com.robertomessa.codetest.compliancecompany.productmanager.model.repository;

import com.robertomessa.codetest.compliancecompany.productmanager.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
