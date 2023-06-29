package com.ruemmai.webapps.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productsService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProducts(
            Product product,
            Model model) {

        productsService.addProduct(product);
        model.addAttribute("products", productsService.findAll());
        return "products.html";
    }
}
