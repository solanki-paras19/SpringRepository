package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.Bus;

@Repository
public interface IBusRepository extends JpaRepository<Bus,String>{

}
