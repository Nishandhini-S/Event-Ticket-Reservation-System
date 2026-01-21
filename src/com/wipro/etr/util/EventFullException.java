package com.wipro.etr.util;

public class EventFullException extends Exception {
    public String toString() {
        return "Event is full. No seats available!";
    }
}
