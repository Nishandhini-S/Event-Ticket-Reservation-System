package com.wipro.etr.entity;

public class Booking {
    private String bookingId;
    private String userId;
    private String eventId;
    private int seatsBooked;
    private double totalFare;

    public Booking(String bookingId, String userId, String eventId, int seatsBooked, double totalFare) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.eventId = eventId;
        this.seatsBooked = seatsBooked;
        this.totalFare = totalFare;
    }

    public String getBookingId() {
        return bookingId;
    }
    public String getUserId() {
        return userId;
    }
    public String getEventId() {
        return eventId;
    }
    public int getSeatsBooked() {
        return seatsBooked;
    }
    public double getTotalFare() {
        return totalFare;
    }
}
