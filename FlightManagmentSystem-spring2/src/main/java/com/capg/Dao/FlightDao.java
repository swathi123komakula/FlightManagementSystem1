package com.capg.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;

@Repository
@Transactional
public class FlightDao implements FlightDaoInterface
{
	
	@PersistenceContext
	EntityManager em;
	
	//Flight DAO
		public String addFlight(Flight flight)
		{
			em.persist(flight);
			return "flight added successfully";
		}
					
		//view all flights
		public List<Flight> viewFlight()
		{
			Query query=em.createQuery("select f from Flight f");
			return query.getResultList();
		}
		
		// View Flight based on Flight Number
		public Flight viewFlight(int flightNumber)
		{
			List <Flight> list=viewFlight();
			Flight flight=null;
			Optional <Flight> optional=list.stream().
					filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
			if(optional.isPresent()) {
				flight=optional.get();
			}
			return flight;
			
		}
	
	//ScheduledFLight DAO
		//Add a shceduled flight
		public String scheduleFlight(ScheduledFlight sf)
		{
			em.persist(sf);
			return "Flight scheduled successfully";
		}
		
		//View all scheduled Flight
		public List<ScheduledFlight> viewScheduledFlights()
		{
			Query query=em.createQuery("select sf from ScheduledFlight sf");
			return query.getResultList();
		}
		
		//View Scheduled FLight based on Flight Number
		public ScheduledFlight viewScheduledFlight(int flightNumber)
		{
			List<ScheduledFlight> list=viewScheduledFlights();
			ScheduledFlight scheduledFlight=null;
			Optional <ScheduledFlight> optional=list.stream().
					filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
			if(optional.isPresent())
			{
				scheduledFlight=optional.get();
			}
			return scheduledFlight;
		}
		
		
		public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
			
			
			List<ScheduledFlight> list=viewScheduledFlights();
			Optional <ScheduledFlight> optional=list.stream().
					filter(sf1->sf1.getFlight().getFlightNumber()==flightNumber).findFirst();
			if(optional.isPresent())
			{
				em.merge(flight);
				em.merge(schedule);
			}
			return "modified successfully";
		}
		
		
		// Delete a Scheduled Flight
		public String deleteScheduledFlight(int flightNumber) {
			em.remove(viewScheduledFlight(flightNumber));
			return "deleted scheduled flight successfully";
		}
		
		
		public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate)
		{
			Query query=em.createQuery("select sf from ScheduledFlight sf where SourceAirport="+sourceAirport+
					"AND DestinationAirport="+destinationAirport+" AND ArrivalDate="+arrivalDate);
			return query.getResultList();
		}
		
	//Airport DAO
		//Add Airport
		public String addAirport(Airport airport)
		{
			em.persist(airport);
			return "airport added successfuly";
		}
		
		//View All airport
		public List<Airport> viewAirport()
		{
			Query query=em.createQuery("Select a from Airport a");
			return query.getResultList();
			
		}
		//View airport based on airport code
		public Airport viewAirport(String airportCode)
		{
			List<Airport> list=viewAirport();
			Airport airport=null;
			Optional <Airport> optional=list.stream().
					filter(a1->a1.getAirportCode().equals(airportCode)).findFirst();
					if(optional.isPresent()) {
						airport=optional.get();
					}
			return airport;
			
		}
		
	//Schedule
		public String addSchedule(Schedule schedule) 
		{
			em.persist(schedule);
			return "scheduled successfully";
		}
		
		public List<Schedule> viewAllSchedule(){
			
			Query query=em.createQuery("select s from Schedule s");
			return query.getResultList();
		}
}
