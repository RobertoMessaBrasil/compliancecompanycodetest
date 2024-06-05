package com.robertomessa.codetest.compliancecompany.productmanager.controller;

import com.robertomessa.codetest.compliancecompany.productmanager.model.ProductEntity;
import com.robertomessa.codetest.compliancecompany.productmanager.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(Model model) {
        List<ProductEntity> productList = this.productRepository.findAll();
        if (productList != null) {
            model.addAttribute("products", productList);
        }
        return "productList";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addProduct(ProductEntity productEntity) {
        this.productRepository.save(productEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateProduct(ProductEntity productEntity) {
        this.productRepository.save(productEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") long productId) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(productId);
        if (productEntity.isPresent()) {
            this.productRepository.delete(productEntity.get());
        }
        return "redirect:/";
    }

}
