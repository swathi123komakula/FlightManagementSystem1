package com.capg.Service;

import java.util.List;

import com.capg.entity.Airport;
import com.capg.entity.ScheduledFlight;

public interface FlightServiceInterface {

	public List<Airport> viewAirport();
	
	public List<ScheduledFlight> viewScheduledFlights();
	public ScheduledFlight viewScheduledFlight(int flightNumber);
	public String scheduleFlight(ScheduledFlight scheduledFlight);
}
