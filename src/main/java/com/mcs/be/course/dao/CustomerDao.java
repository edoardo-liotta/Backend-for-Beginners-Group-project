package com.mcs.be.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcs.be.course.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {

}
