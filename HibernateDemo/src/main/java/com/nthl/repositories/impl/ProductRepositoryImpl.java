/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nthl.repositories.impl;

import com.nthl.hibernatedemo.HibernateConfigs;
import com.nthl.pojo.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {

    private static final int PAGE_SIZE = 6;

    public List<Product> getProducts(Map<String, String> params) {
        try ( Session s = HibernateConfigs.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);

            // Loc du lieu
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();

                String kw = params.get("kw");
                if (!kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));

                }

                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
                }

                String toPrice = params.get("toPrice");
                if (toPrice != null && !toPrice.isEmpty()) {
                    predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
                }

                String cateId = params.get("cateId");
                if (cateId != null && !cateId.isEmpty()) {
                    predicates.add(b.equal(root.get("category").as(Integer.class), cateId));
                }

                q.where(predicates.toArray(Predicate[]::new));
            }
            // Sap xep du lieu
            
            q.orderBy(b.desc(root.get(params.getOrDefault("sortBy", "id"))));

            Query query = s.createQuery(q);

            if (params != null) {
                String page = params.get("page");
                if (page != null) {
                    int p = Integer.parseInt(page);
                    int start = (p - 1) * PAGE_SIZE;

                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
            }

            return query.getResultList();

        }
    }
}
