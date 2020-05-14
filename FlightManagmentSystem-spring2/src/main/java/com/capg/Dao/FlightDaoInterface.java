package com.capg.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;

@Repository
public interface FlightDaoInterface {
	
	public String scheduleFlight(ScheduledFlight sf);
	public List<ScheduledFlight> viewScheduledFlights();
	public ScheduledFlight viewScheduledFlight(int flightNumber);
	public String deleteScheduledFlight(int flightNumber);
	
	public String addFlight(Flight flight);
	public List<Flight> viewFlight();
	public Flight viewFlight(int flightNumber);
	
	public String addAirport(Airport airport);
	public List<Airport> viewAirport();
	public Airport viewAirport(String airportCode);
	
	public String addSchedule(Schedule schedule) ;

}
