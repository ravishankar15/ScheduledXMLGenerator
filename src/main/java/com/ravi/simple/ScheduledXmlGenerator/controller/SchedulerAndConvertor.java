package com.ravi.simple.ScheduledXmlGenerator.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.ravi.simple.ScheduledXmlGenerator.dto.BookingDetails;
import com.ravi.simple.ScheduledXmlGenerator.util.EventUtil;
import com.ravi.simple.ScheduledXmlGenerator.util.ProjectConstants;
import com.ravi.simple.ScheduledXmlGenerator.util.XMLConverter;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.BOOKINGDETAILStype;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.TICKET;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.TICKET.HEADER;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.TICKET.HEADER.EVENTHEADER;

public class SchedulerAndConvertor implements Runnable {
	
	private Logger logger = Logger.getLogger(SchedulerAndConvertor.class);
	
	public static List<BookingDetails> bookingSyncList = Collections.synchronizedList(new ArrayList<BookingDetails>());
	
	private List<BookingDetails> bookingList = null;	
	private int threadNum = 0;
	private int noOfBookings = 0;
	private XMLConverter xmlConverter;
	
	public SchedulerAndConvertor(List<BookingDetails> bookingList, int threadNum, int noOfBookings, XMLConverter xmlConverter){
		this.bookingList = bookingList;
		this.threadNum = threadNum;
		this.noOfBookings = noOfBookings;
		this.xmlConverter = xmlConverter;
		if(bookingList != null)
			logger.info("Number of services running in Thread Number "+threadNum + " is "+ bookingList.size());
	}
	
	@Override
	public void run() {
		logger.info("*************************Initiating the Scheduler and starting the conversion***********************");
		logger.info("ScheduledXMLConvertor "+ threadNum + " starts....");
		for(BookingDetails bookings: bookingList){
			calcNoOfDaysRemaining(bookings);
			if(bookingSyncList.size() == noOfBookings){
				for(BookingDetails book: bookingSyncList){
					TICKET ticket = new TICKET();
					HEADER header = new HEADER();
					
					EVENTHEADER eventHeader = EventUtil.constructEventHeader(book.getBookingId(), ProjectConstants.BOOKING_EVENT);
					header.setEVENTHEADER(eventHeader);
					ticket.setHEADER(header);
					
					BOOKINGDETAILStype bookingDetailsType = EventUtil.constructBookingDetailType(book);
					ticket.setBOOKINGDETAILS(bookingDetailsType);
					
					String bookingXml = xmlConverter.convertObjectToXML(ticket);
					logger.info("************************XML Message******************");
					logger.info(bookingXml);					
					
				}
			}
		}
	}
	
	
	private void calcNoOfDaysRemaining(BookingDetails booking){
	    try {
			Date jDate = new SimpleDateFormat(ProjectConstants.DT_FORMAT).parse(booking.getJourneyDate());
			Date cDate = new Date();
			
			long diffInMillies = Math.abs(jDate.getTime() - cDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			booking.setNoOfDaysRemain(String.valueOf(diff));
			bookingSyncList.add(booking);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.info("Parse Exception in calcNoOfDaysRemaining(BookingDetails) "+e);
		}
	    
	}

}
