package com.ravi.simple.ScheduledXmlGenerator.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;

public class XMLConverter {
	
	private Marshaller marshaller;
	private Logger logger = Logger.getLogger(XMLConverter.class);

	public Marshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}
	
	
	public String convertObjectToXML(Object type){
		StringWriter sw = new StringWriter();
		String resultXml = null;
		try {
			marshaller.marshal(type, new StreamResult(sw));
			resultXml = sw.toString();
		} catch (XmlMappingException | IOException e) {
			logger.error("XMLConvertor Exception: "+e);
		}
		return resultXml;
	}
	

}
