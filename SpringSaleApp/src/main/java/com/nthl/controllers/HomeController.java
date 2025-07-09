/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nthl.controllers;


import com.nthl.pojo.Category;
import com.nthl.services.CategoryService;
import com.nthl.services.ProductService;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService cateService;
    @Autowired
    private ProductService prodService;
    
    @RequestMapping("/")
    public String index (Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("products", this.prodService.getProducts(params));
        return "index";
    }
    
    public void commonResponses(Model model) {
        model.addAttribute("categories", this.cateService.getCates());
    }
    
    @RequestMapping("/products")
    public String listProduct() {
        return "products";
    }
}
