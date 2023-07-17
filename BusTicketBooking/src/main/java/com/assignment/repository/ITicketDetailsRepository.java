package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.TicketDetails;


@Repository
public interface ITicketDetailsRepository extends JpaRepository<TicketDetails,Integer> {

}
