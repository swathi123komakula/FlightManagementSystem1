package com.capg.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capg.Dao.FlightDao;
import com.capg.Exception.FlightManagmentException;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;


@Service
public class FlightService implements FlightServiceInterface
{
	@Autowired
	private FlightDao flightDao;
	
	
	//Flight Class Implementation
		public List<Flight> viewFlight(){
			return flightDao.viewFlight();
		}
		//Add Flight
		public String addFlight(Flight flight) throws FlightManagmentException {
			
			List<Flight> list=viewFlight();
			Optional <Flight> optional=list.stream().
					filter(f1->f1.getFlightNumber()==flight.getFlightNumber()).findFirst();
			
			if(optional.isPresent())
			{
				throw new FlightManagmentException("flight Number already exist try new one");
				
			}
			
			else
				return flightDao.addFlight(flight);
		}
		
		// View Flight based on flight number
		public Flight viewFlight(int flightNumber) throws FlightManagmentException {
			
			
			List<Flight> list=viewFlight();
			Optional <Flight> optional=list.stream().
					filter(f1->f1.getFlightNumber()==flightNumber).findFirst();
			
			if(optional.isPresent())
			{
				return flightDao.viewFlight(flightNumber);
			}
			
			else
				throw new FlightManagmentException("flight Number does not exist");
			
		}
	
	
	
	//Airport Class Implementation
		public String addAirport(Airport airport) throws FlightManagmentException 
		{
			
			List<Airport> list=viewAirport();
			Optional <Airport> optional=list.stream().
					filter(a1->a1.getAirportCode().equalsIgnoreCase(airport.getAirportCode())).findFirst();
			
			if(optional.isPresent())
			{
				throw new FlightManagmentException("Airport Code already exist try new one");
				
			}
			
			else
				return flightDao.addAirport(airport);
		}
	
		public List<Airport> viewAirport(){
			return flightDao.viewAirport();
		}
		
		public Airport viewAirport(String airportCode) throws FlightManagmentException
		{
			
			List<Airport> list=viewAirport();
			Optional <Airport> optional=list.stream().
					filter(a1->a1.getAirportCode().equalsIgnoreCase(airportCode)).findFirst();
			
			if(optional.isPresent())
			{
				return flightDao.viewAirport(airportCode);
			}
			
			else
				throw new FlightManagmentException("Airport Code does not exist");
		}
	
	
	
	//ScheduledFLight Class implementation 
		public List<ScheduledFlight> viewScheduledFlights(){
			return flightDao.viewScheduledFlights();
		}
		
		public ScheduledFlight viewScheduledFlight(int flightNumber) {
			return flightDao.viewScheduledFlight(flightNumber);
		}
		
		public String scheduleFlight(ScheduledFlight scheduledFlight) {
			return flightDao.scheduleFlight(scheduledFlight);
		}
		
		public String modifyScheduledFlight(Flight flight,Schedule schedule,int flightNumber) {
			return flightDao.modifyScheduledFlight(flight, schedule, flightNumber);
		}
		
		public String deleteScheduledFlight(int flightNumber) {
			return flightDao.deleteScheduledFlight(flightNumber);
		}
		
		public List<ScheduledFlight> viewScheduledFlights(Airport sourceAirport,Airport destinationAirport,LocalDate arrivalDate){
			return flightDao.viewScheduledFlights(sourceAirport, destinationAirport, arrivalDate);
		}

		
}
