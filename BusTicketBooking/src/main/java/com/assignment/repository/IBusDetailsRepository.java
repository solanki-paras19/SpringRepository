package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.BusDetails;

@Repository
public interface IBusDetailsRepository extends JpaRepository<BusDetails,String>{

}
