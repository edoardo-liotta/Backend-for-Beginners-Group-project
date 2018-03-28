package com.mcs.be.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcs.be.course.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {

}
