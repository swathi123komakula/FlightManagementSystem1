package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="scheduledFlight")
public class ScheduledFlight {

	@Id
	private int scheduledFlightId;
	
	@OneToOne
	@JoinColumn(name="flight_number",referencedColumnName = "flightNumber")
	private Flight flight;
	
	@Column
	private int availableSeats;
	
	@OneToOne
	@JoinColumn(name="schedule_id",referencedColumnName = "scheduleId")
	private Schedule schedule;

	public ScheduledFlight(int scheduledFlightId, Flight flight, int availableSeats, Schedule schedule) {
		super();
		this.scheduledFlightId = scheduledFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScheduledFlightId() {
		return scheduledFlightId;
	}

	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", flight=" + flight + ", availableSeats="
				+ availableSeats + ", schedule=" + schedule + "]";
	}

	

	
	
}
