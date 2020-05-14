package com.capg.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Exception.FlightManagmentException;
import com.capg.Service.FlightService;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;


@Component
@CrossOrigin("http://localhost:4200")
@RestController
public class FlightController 
{
	@Autowired
	FlightService flightService;
	
	//ScheduledFlight
		@CrossOrigin
		@GetMapping("/scheduledFlight")
		public List<ScheduledFlight> viewScheduledFlights() // List of all Scheduled Flight that are scheduled
		{
			return flightService.viewScheduledFlights();
		}
		
		@CrossOrigin
		@GetMapping(value="/scheduledFlight/{flightNumber}",produces= {"application/json"})
		public ScheduledFlight viewScheduledFlight(@PathVariable int flightNumber) // Search specific scheduled Flight bases on Flight Number
		{
			return flightService.viewScheduledFlight(flightNumber);
		}
		
		@PostMapping(value="/scheduledFlight/add",produces= {"application/json"})
		public String scheduleFlight(@RequestBody ScheduledFlight scheduledFlight) //Add a schedule flight based on available Data
		{
			return flightService.scheduleFlight(scheduledFlight);
		}
		
		@DeleteMapping(value="/scheduledFlight/delete/{flightNumber}")
		public String deleteScheduledFlight(@PathVariable int flightNumber) // Delete the scheduled flight based on Flight Number
		{
			return flightService.deleteScheduledFlight(flightNumber);
		}
		
	
	//Flight
		@GetMapping("/flight")
		public List<Flight> viewFlight() // List of all the flights available
		{
			return flightService.viewFlight();
		}
		
		@GetMapping(value="/flight/{flightNumber}",produces= {"application/json"})
		public Flight viewFlight(@PathVariable int flightNumber) throws FlightManagmentException // Search flight based on Flight Number
		{
			return flightService.viewFlight(flightNumber);
		}
		
		@PostMapping(value="/flight/add",consumes={"application/json"})
		public String addFlight(@RequestBody Flight flight) throws FlightManagmentException // Add flight
		{
			return flightService.addFlight(flight);
		}
		
	
	//Airport
		@PostMapping(value="/airport/add",consumes= {"application/json"})
		public String addAirport(@RequestBody Airport airport) throws FlightManagmentException //Add airport 
		{
			return flightService.addAirport(airport);
			
		}
	
		@CrossOrigin
		@GetMapping(value="/airport")
		public List<Airport> viewAirport() // View all airport 
		{
			return flightService.viewAirport();
		}
		
		@GetMapping(value="/airport/{airportCode}")
		public Airport viewAirport(@PathVariable String airportCode) throws FlightManagmentException // Search flight based on airport Code
		{
			return flightService.viewAirport(airportCode);
		}
		
		
}
