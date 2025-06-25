/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nthl.hibernatedemo;


import com.nthl.repositories.impl.CategoryRepositoryImpl;
import com.nthl.repositories.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.err.println(c.getName()));
        Map<String, String> params = new HashMap<>();
        params.put("kw", "iPhone");
//        params.put("fromPrice", "30000000");
//        error no jta platform and null pointer
//        params.put("page", "1");
        
        ProductRepositoryImpl s = new ProductRepositoryImpl();
        s.getProducts(params).forEach(p -> System.err.printf("%d - %s -%.1f\n", p.getId(), p.getName(), p.getPrice()));
    }
}
