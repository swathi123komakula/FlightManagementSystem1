package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {

	@Id
	private int flightNumber;
	@Column
	private String flightModel;
	@Column
	private String carrierName;
	@Column
	private int seatCapacity;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="sf")
	private ScheduledFlight scheduledFlight;



	public Flight(int flightNumber, String flightModel, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	
//
//	public List<ScheduledFlight> getScheduledFlight() {
//		return scheduledFlight;
//	}
//
//	public void setScheduledFlight(List<ScheduledFlight> scheduledFlight) {
//		this.scheduledFlight = scheduledFlight;
//	}
//
//	@Override
//	public String toString() {
//		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
//				+ ", seatCapacity=" + seatCapacity + ", scheduledFlight=" + scheduledFlight + "]";
//	}
	
	
}
