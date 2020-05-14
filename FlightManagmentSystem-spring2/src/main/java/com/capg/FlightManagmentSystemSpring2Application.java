package com.capg;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.Dao.FlightDao;
import com.capg.entity.Airport;
import com.capg.entity.Flight;
import com.capg.entity.Schedule;
import com.capg.entity.ScheduledFlight;

@SpringBootApplication
public class FlightManagmentSystemSpring2Application implements CommandLineRunner{
	
	@Autowired
	FlightDao flightdao;
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagmentSystemSpring2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println("You are using Flight Management System.");
		
		
	}

}
