package com.wipro.etr.entity;

public class Event {
        private String eventId;
        private String eventName;
        private String eventDate;
        private int totalSeats;
        private int availableSeats;
        private double ticketPrice;
        
   public Event(String eventId, String eventName, String eventDate, int totalSeats, int availableSeats, double ticketPrice) {
       this.eventId = eventId;
       this.eventName = eventName;
       this.eventDate = eventDate;
       this.totalSeats = totalSeats;
       this.availableSeats = availableSeats;
       this.ticketPrice = ticketPrice;
   }

   public String getEventId() {
       return eventId;
   }
   public String getEventName() {
       return eventName;
   }
   public int getAvailableSeats() {
       return availableSeats;
   }
   public void setAvailableSeats(int seats) {
       this.availableSeats = seats;
   }
   public double getTicketPrice() {
       return ticketPrice;
   }
}
