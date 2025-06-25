/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nthl.repositories.impl;

import com.nthl.hibernatedemo.HibernateConfigs;
import com.nthl.pojo.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsRepositoryImpl {
    public List<Object[]> statsRevenueByProduct() {
        try ( Session s = HibernateConfigs.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root r = q.
    }
}
