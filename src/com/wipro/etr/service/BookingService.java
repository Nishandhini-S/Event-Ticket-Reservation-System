package com.wipro.etr.service;

import java.util.ArrayList;
import java.util.UUID;

import com.wipro.etr.entity.*;
import com.wipro.etr.util.*;

public class BookingService {

    private ArrayList<User> users;
    private ArrayList<Event> events;
    private ArrayList<Booking> bookings;

    public BookingService(ArrayList<User> users, ArrayList<Event> events, ArrayList<Booking> bookings) {
        this.users = users;
        this.events = events;
        this.bookings = bookings;
    }

    public boolean validateUser(String userId) throws InvalidUserException {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return true;
            }
        }
        throw new InvalidUserException();
    }

    public Event findEvent(String eventId) throws EventNotFoundException {
        for (Event e : events) {
            if (e.getEventId().equals(eventId)) {
                return e;
            }
        }
        throw new EventNotFoundException();
    }

    public double calculateFare(Event event, int seats) {
        return event.getTicketPrice() * seats;
    }

    public Booking bookTicket(String userId, String eventId, int seats) throws Exception {
        validateUser(userId);
        Event event = findEvent(eventId);

        if (seats <= 0 || event.getAvailableSeats() < seats) {
            throw new EventFullException();
        }

        double fare = calculateFare(event, seats);
        String bookingId = UUID.randomUUID().toString();

        event.setAvailableSeats(event.getAvailableSeats() - seats);

        Booking booking = new Booking(bookingId, userId, eventId, seats, fare);
        bookings.add(booking);

        return booking;
    }

    public void cancelBooking(String bookingId) throws BookingNotFoundException {
        Booking found = null;

        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                found = b;
                break;
            }
        }

        if (found == null) {
            throw new BookingNotFoundException();
        }

        try {
            Event event = findEvent(found.getEventId());
            event.setAvailableSeats(event.getAvailableSeats() + found.getSeatsBooked());
        } catch (Exception e) {}

        bookings.remove(found);
    }

    public void printUserBookings(String userId) {
        for (Booking b : bookings) {
            if (b.getUserId().equals(userId)) {
                System.out.println("Booking ID: " + b.getBookingId());
                System.out.println("Seats: " + b.getSeatsBooked());
                System.out.println("Total Fare: " + b.getTotalFare());
                System.out.println("----------------------");
            }
        }
    }
}
