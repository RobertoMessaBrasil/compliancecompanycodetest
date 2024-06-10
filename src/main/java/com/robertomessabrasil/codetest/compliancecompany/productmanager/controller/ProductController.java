package com.robertomessabrasil.codetest.compliancecompany.productmanager.controller;

import com.robertomessabrasil.codetest.compliancecompany.productmanager.dto.CategoryOutput;
import com.robertomessabrasil.codetest.compliancecompany.productmanager.dto.ProductInput;
import com.robertomessabrasil.codetest.compliancecompany.productmanager.dto.ProductOutput;
import com.robertomessabrasil.codetest.compliancecompany.productmanager.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String listProducts() {
        return "redirect:/0";
    }

    @RequestMapping(value = "/{pageIndex}", method = RequestMethod.GET)
    public String listProducts(@PathVariable Optional<Integer> pageIndex, Model model) {

        int index = pageIndex.orElse(0);

        List<ProductOutput> productList = this.productService.findAll(index);

        model.addAttribute("products", productList);
        model.addAttribute("indexes", this.productService.getIndexes());

        return "productList";
    }

    @RequestMapping(value = "editProduct/{productId}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Long productId, Model model) {

        Optional<ProductOutput> productEntity = this.productService.findById(productId);

        if (productEntity.isPresent()) {

            List<CategoryOutput> categoryOutputs = this.productService.findAllCategories();

            model.addAttribute("product", productEntity.get());
            model.addAttribute("categories", categoryOutputs);
        } else {
            model.addAttribute("error", "Product Not Found");
        }

        return "editProduct";
    }

    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") ProductInput product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "editProduct";
        }

        this.productService.updateProduct(product);

        return "redirect:/";
    }

    @RequestMapping(value = "addProduct", method = RequestMethod.GET)
    public String newProduct(Model model) {

        List<CategoryOutput> categoryOutputs = this.productService.findAllCategories();

        model.addAttribute("product", new ProductInput());
        model.addAttribute("categories", categoryOutputs);

        return "newProduct";
    }

    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") ProductInput product, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            List<CategoryOutput> categoryOutputs = this.productService.findAllCategories();

            model.addAttribute("categories", categoryOutputs);

            return "newProduct";
        }

        this.productService.createProduct(product);

        return "redirect:/";
    }

    @RequestMapping(value = "deleteConfirm/{productId}", method = RequestMethod.GET)
    public String deleteConfirm(@PathVariable Long productId, Model model) {
        model.addAttribute("productId", productId);
        return "deleteConfirm";
    }

    @RequestMapping(value = "deleteProduct/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") Long productId, Model model) {

        Optional<ProductOutput> productEntity = this.productService.findById(productId);

        if (productEntity.isPresent()) {
            this.productService.deleteProduct(productEntity.get().getId());
        } else {
            model.addAttribute("error", "Product Not Found");
            return "deleteConfirm";
        }

        return "redirect:/";

    }

}
