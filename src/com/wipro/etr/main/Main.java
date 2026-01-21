package com.wipro.etr.main;
import java.util.ArrayList;
import com.wipro.etr.entity.*;
import com.wipro.etr.service.BookingService;
import com.wipro.etr.util.*;
public class Main {
 public static void main(String[] args) {
 ArrayList<User> users = new ArrayList<>();
 users.add(new User("U001", "Manoj Kumar", "9876543210"));
 users.add(new User("U002", "Sneha Reddy", "9123456780"));
 
 ArrayList<Event> events = new ArrayList<>();
 events.add(new Event("E101", "Music Fest 2025", "2025-12-18", 200, 200, 1500.0));
 events.add(new Event("E202", "Tech Conference", "2025-11-10", 300, 300, 2500.0));
 
 ArrayList<Booking> bookings = new ArrayList<>();
 BookingService service = new BookingService(users, events, bookings);
 try {
 Booking b1 = service.bookTicket("U001", "E101", 4);
 System.out.println("Booking Successful! ID: " + b1.getBookingId());
 System.out.println("\n--- Bookings for User U001 ---");
 service.printUserBookings("U001");
 System.out.println("\nCancelling booking...");
 service.cancelBooking(b1.getBookingId());
 System.out.println("Booking Cancelled!");
 } catch (InvalidUserException | EventFullException |
 EventNotFoundException | BookingNotFoundException |
 BookingOperationException ex) {
 System.out.println(ex.toString());
 }
 catch (Exception ex) {
 System.out.println("Unexpected Error: " + ex);
 }
 }
}