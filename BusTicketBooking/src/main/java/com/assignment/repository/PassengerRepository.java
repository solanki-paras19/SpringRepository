package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.PassengerDetails;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerDetails,Integer>{

}
