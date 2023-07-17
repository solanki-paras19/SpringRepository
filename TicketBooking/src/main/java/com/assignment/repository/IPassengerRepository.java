package com.assignment.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.entities.Passenger;
import com.assignment.entities.Ticket;


@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Integer> {

	public List<Passenger> findAllByTicket(int ticketId);
	
	@Query("select p from Passenger p where p.ticket=:ticketId")
	public List<Passenger> getPassengers(@Param(value="ticketId") int uid);
}
