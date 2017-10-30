package com.ravi.simple.ScheduledXmlGenerator.dto;

public class BookingDetails {
	
	private String name;
	private String bookingId;
	private String journeyDate;
	private String origin;
	private String destination;
	private String noOfDaysRemain;

	public String getNoOfDaysRemain() {
		return noOfDaysRemain;
	}
	public void setNoOfDaysRemain(String noOfDaysRemain) {
		this.noOfDaysRemain = noOfDaysRemain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
