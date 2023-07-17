package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entities.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {

}
