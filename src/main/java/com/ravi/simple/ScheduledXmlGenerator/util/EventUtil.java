package com.ravi.simple.ScheduledXmlGenerator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.ravi.simple.ScheduledXmlGenerator.controller.SchedulerAndConvertor;
import com.ravi.simple.ScheduledXmlGenerator.dto.BookingDetails;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.BOOKINGDETAILStype;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.BOOKINGDETAILStype.BOOKINGS;
import com.ravi.simple.ScheduledXmlGenerator.xmlmapping.TICKET.HEADER.EVENTHEADER;

public class EventUtil {
	
	private static final Logger logger = Logger.getLogger(SchedulerAndConvertor.class);
	
	public static BOOKINGDETAILStype constructBookingDetailType(BookingDetails bookings){
		
		
		BOOKINGDETAILStype type = new BOOKINGDETAILStype();
		BOOKINGS oBook = new BOOKINGS();
		
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat dtFormat = new SimpleDateFormat(ProjectConstants.DT_FORMAT);
		
		try {			
			oBook.setName(bookings.getName());
			oBook.setOrigin(bookings.getOrigin());
			oBook.setDestination(bookings.getDestination());
			oBook.setNoOfDaysRemain(Integer.parseInt(bookings.getNoOfDaysRemain()));
			oBook.setBookingId(Integer.parseInt(bookings.getBookingId()));
			if(bookings.getJourneyDate() != null){
				Date jDate = dtFormat.parse(bookings.getJourneyDate());
				cal.setTime(jDate);
				XMLGregorianCalendar jrDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
				oBook.setJourneyDate(jrDate);
			}
			type.getBOOKINGS().add(oBook);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException in constructBookingDetailType(BookingDetails) "+e);
		} catch (ParseException e) {
			logger.error("ParseException in constructBookingDetailType(BookingDetails) "+e);
		} catch (DatatypeConfigurationException e) {
			logger.error("DatatypeConfigurationException in constructBookingDetailType(BookingDetails) "+e);
		} catch (Exception e) {
			logger.error("Exception in constructBookingDetailType(BookingDetails) "+e);
		}
		
		return type;
	}
	
	public static EVENTHEADER constructEventHeader(String bookingId, String eventName){
		EVENTHEADER eventHeader = new EVENTHEADER();
		try {
			if(bookingId != null)
				eventHeader.setBookingId(Integer.parseInt(bookingId));
			eventHeader.setEventName(eventName);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException in constructEventHeader(String, String) "+e);
		} catch (Exception e) {
			logger.error("Exception in constructEventHeader(String, String) "+e);
		}
		return eventHeader;
	}

}
