//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 12:01:35 PM IST 
//


package com.ravi.simple.ScheduledXmlGenerator.xmlmapping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HEADER">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EVENTHEADER">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="eventName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="bookingId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BOOKINGDETAILS" type="{}BOOKINGDETAILStype"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "bookingdetails"
})
@XmlRootElement(name = "TICKET")
public class TICKET {

    @XmlElement(name = "HEADER", required = true)
    protected TICKET.HEADER header;
    @XmlElement(name = "BOOKINGDETAILS", required = true)
    protected BOOKINGDETAILStype bookingdetails;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link TICKET.HEADER }
     *     
     */
    public TICKET.HEADER getHEADER() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link TICKET.HEADER }
     *     
     */
    public void setHEADER(TICKET.HEADER value) {
        this.header = value;
    }

    /**
     * Gets the value of the bookingdetails property.
     * 
     * @return
     *     possible object is
     *     {@link BOOKINGDETAILStype }
     *     
     */
    public BOOKINGDETAILStype getBOOKINGDETAILS() {
        return bookingdetails;
    }

    /**
     * Sets the value of the bookingdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BOOKINGDETAILStype }
     *     
     */
    public void setBOOKINGDETAILS(BOOKINGDETAILStype value) {
        this.bookingdetails = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="EVENTHEADER">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="eventName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="bookingId" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "eventheader"
    })
    public static class HEADER {

        @XmlElement(name = "EVENTHEADER", required = true)
        protected TICKET.HEADER.EVENTHEADER eventheader;

        /**
         * Gets the value of the eventheader property.
         * 
         * @return
         *     possible object is
         *     {@link TICKET.HEADER.EVENTHEADER }
         *     
         */
        public TICKET.HEADER.EVENTHEADER getEVENTHEADER() {
            return eventheader;
        }

        /**
         * Sets the value of the eventheader property.
         * 
         * @param value
         *     allowed object is
         *     {@link TICKET.HEADER.EVENTHEADER }
         *     
         */
        public void setEVENTHEADER(TICKET.HEADER.EVENTHEADER value) {
            this.eventheader = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="eventName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="bookingId" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class EVENTHEADER {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "eventName", required = true)
            protected String eventName;
            @XmlAttribute(name = "bookingId")
            protected Integer bookingId;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the eventName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEventName() {
                return eventName;
            }

            /**
             * Sets the value of the eventName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEventName(String value) {
                this.eventName = value;
            }

            /**
             * Gets the value of the bookingId property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getBookingId() {
                return bookingId;
            }

            /**
             * Sets the value of the bookingId property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setBookingId(Integer value) {
                this.bookingId = value;
            }

        }

    }

}