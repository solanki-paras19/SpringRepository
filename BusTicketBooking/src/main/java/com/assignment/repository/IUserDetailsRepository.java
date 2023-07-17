package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.UserDetails;

@Repository
public interface IUserDetailsRepository extends JpaRepository<UserDetails,String>{

}
