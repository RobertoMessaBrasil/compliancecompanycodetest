package com.robertomessa.codetest.compliancecompany.productmanager.service;

import com.robertomessa.codetest.compliancecompany.productmanager.dto.CategoryOutput;
import com.robertomessa.codetest.compliancecompany.productmanager.dto.ProductInput;
import com.robertomessa.codetest.compliancecompany.productmanager.dto.ProductOutput;
import com.robertomessa.codetest.compliancecompany.productmanager.model.CategoryEntity;
import com.robertomessa.codetest.compliancecompany.productmanager.model.ProductEntity;
import com.robertomessa.codetest.compliancecompany.productmanager.model.repository.CategoryRepository;
import com.robertomessa.codetest.compliancecompany.productmanager.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductOutput> findAll() {
        List<ProductEntity> productEntities = this.productRepository.findAll();
        List<ProductOutput> productOutputs = new ArrayList<>();
        for (ProductEntity product : productEntities) {

            ProductOutput productOutput = new ProductOutput();
            productOutput.setId(product.getId());
            productOutput.setName(product.getName());
            productOutput.setPrice(product.getPrice());
            productOutput.setAvailable(product.getAvailable());
            productOutput.setDescription(product.getDescription());

            List<CategoryOutput> categoryOutputs = new ArrayList<>();

            for (CategoryEntity category : product.getCategories()) {
                CategoryOutput categoryOutput = new CategoryOutput();
                categoryOutput.setId(category.getId());
                categoryOutput.setName(category.getName());
                categoryOutputs.add(categoryOutput);
            }

            productOutput.setCategories(categoryOutputs);

            productOutputs.add(productOutput);

        }

        return productOutputs;

    }

    public Optional<ProductOutput> findById(Long productId) {

        Optional<ProductEntity> productEntity = this.productRepository.findById(productId);

        if (productEntity.isEmpty()) {
            return Optional.empty();
        }

        ProductEntity product = productEntity.get();

        ProductOutput productOutput = new ProductOutput();
        productOutput.setId(product.getId());
        productOutput.setName(product.getName());
        productOutput.setPrice(product.getPrice());
        productOutput.setAvailable(product.getAvailable());
        productOutput.setDescription(product.getDescription());

        List<CategoryOutput> categoryOutputs = new ArrayList<>();

        for (CategoryEntity category : product.getCategories()) {
            CategoryOutput categoryOutput = new CategoryOutput();
            categoryOutput.setId(category.getId());
            categoryOutput.setName(category.getName());
            categoryOutputs.add(categoryOutput);
        }

        productOutput.setCategories(categoryOutputs);

        return Optional.of(productOutput);
    }

    public ProductEntity createProduct(@Valid ProductInput product) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setAvailable(product.getAvailable());
        productEntity.setDescription(product.getDescription());

        Optional<CategoryEntity> categoryEntity = this.categoryRepository.findById(product.getCategoryId());

        productEntity.setCategories(new HashSet<>(Arrays.asList(categoryEntity.get())));

        return this.productRepository.save(productEntity);

    }

    public ProductEntity updateProduct(@Valid ProductInput product) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setAvailable(product.getAvailable());
        productEntity.setDescription(product.getDescription());

        Optional<CategoryEntity> categoryEntity = this.categoryRepository.findById(product.getCategoryId());

        productEntity.setCategories(new HashSet<>(Arrays.asList(categoryEntity.get())));

        return this.productRepository.save(productEntity);

    }

    public void deleteProduct(long productId) {
        this.productRepository.deleteById(productId);
    }

    public List<CategoryOutput> findAllCategories() {

        List<CategoryEntity> categoryEntities = this.categoryRepository.findAll();

        List<CategoryOutput> categoryOutputs = new ArrayList<>();

        for (CategoryEntity category : categoryEntities) {

            CategoryOutput categoryOutput = new CategoryOutput();
            categoryOutput.setId(category.getId());
            categoryOutput.setName(category.getName());
            categoryOutputs.add(categoryOutput);
        }

        return categoryOutputs;

    }
}
