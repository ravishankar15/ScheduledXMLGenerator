package com.ravi.simple.ScheduledXmlGenerator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ravi.simple.ScheduledXmlGenerator.dto.BookingDetails;
import com.ravi.simple.ScheduledXmlGenerator.util.XMLConverter;

@Component
@EnableScheduling
public class Processor {
	
	private Logger logger = Logger.getLogger(Processor.class);
	private List<BookingDetails> bookingList;
	
	@Autowired
	private XMLConverter xmlConverter;
	
	@Scheduled(fixedRate = 30*60*60, initialDelay = 10 * 1)
	public void beginScheduledConvertion(){
		logger.info("******************Begining the Scheduled Conversion*****************");
		populateValues();
		int noOfBookings = bookingList.size();
		logger.info("Total Number of Bookings: "+noOfBookings);
		if(noOfBookings == 0)
			logger.info("Number of bookings is 0, so no program initiates...");
		else{
			int noOfThreads = 2;
			if(noOfThreads > noOfBookings){
				logger.info("No of threads is greater than the number of bookings hence reducing the thread count");
				noOfThreads = noOfBookings;
			}
			int chunkSize = noOfBookings/noOfThreads;
			int remainder = noOfBookings % noOfThreads;
			int currentIndex = 0; int lastIndex = 0;
			List<BookingDetails> bookingListSub = null;
			SchedulerAndConvertor.bookingSyncList.clear();
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			for(int threadNum=1; threadNum < noOfThreads+1; threadNum++){
				if(threadNum == noOfThreads){
					bookingListSub = new ArrayList<>(bookingList.subList(currentIndex, noOfBookings));
				} else {
					lastIndex = lastIndex + chunkSize;
					if(remainder > 0){
						remainder--;
						lastIndex++;
					}
					bookingListSub = new ArrayList<>(bookingList.subList(currentIndex, lastIndex));
					currentIndex = lastIndex;					
				}
				
				SchedulerAndConvertor schedConvInstance = new SchedulerAndConvertor(bookingListSub, threadNum, noOfBookings, xmlConverter);
				executor.execute(schedConvInstance);
				logger.info("THREAD "+threadNum+" is posted for processing...");
			}
			executor.shutdown();
			logger.info("Number of active Threads:" + executor.getActiveCount());
			logger.info("All threads are posted processing request.");
			logger.info("Task For Monitoring SERVICEs Health Ended.");
				
		}
	}
	private void populateValues(){
		bookingList = new ArrayList<BookingDetails>();
		
		BookingDetails booking = new BookingDetails();
		booking.setBookingId("103010");
		booking.setName("Ned StarK");
		booking.setOrigin("Chennai");
		booking.setDestination("Delhi");
		booking.setJourneyDate("30-Oct-2017");
		bookingList.add(booking);
		
		BookingDetails booking1 = new BookingDetails();
		booking1.setBookingId("110310");
		booking1.setName("Arya StarK");
		booking1.setOrigin("London");
		booking1.setDestination("Malasiya");
		booking1.setJourneyDate("03-Nov-2017");
		bookingList.add(booking1);
		
		BookingDetails booking2 = new BookingDetails();
		booking2.setBookingId("110510");
		booking2.setName("Tyrion Lanister");
		booking2.setOrigin("Hongkong");
		booking2.setDestination("Newyork");
		booking2.setJourneyDate("05-Nov-2017");
		bookingList.add(booking2);
		
		BookingDetails booking3 = new BookingDetails();
		booking3.setBookingId("111510");
		booking3.setName("Oliver Queen");
		booking3.setOrigin("Dubai");
		booking3.setDestination("Starling City");
		booking3.setJourneyDate("15-Nov-2017");
		bookingList.add(booking3);
	}
}

