package com.beck;

import org.junit.jupiter.api.Test;

import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;

public class FlightWithPassengerTest {

    private Flight flight = new Flight("AA123",1);

    @Test
    public void testAddRemovePassengers(){
        Passenger passenger = new Passenger("1111","Mike Pen","US");
        assertTrue(flight.addPassenger(passenger));
        assertEquals(1,flight.getNumberOfPassengers());

        assertTrue(flight.removePassenger(passenger));
        assertEquals(0,flight.getNumberOfPassengers());
    }

    @Test
    public void testNumberOfSeats(){
        Passenger passenger1 = new Passenger("1111","Mike Pen","US");
        flight.addPassenger(passenger1);

        assertEquals(1,flight.getNumberOfPassengers());

        Passenger passenger2 = new Passenger("2222", "Mike Jo", "GB");

        assertThrows(RuntimeException.class,
                ()->flight.addPassenger(passenger2));
    }


}
