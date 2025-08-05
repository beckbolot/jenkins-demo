package com.beck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    public void testPassengerCreation(){
        Passenger passenger = new Passenger("1111","John Smith","US");
        assertNotNull(passenger);
    }

    @Test
    public void testInvalidCountryCode(){
        assertThrows(RuntimeException.class, () -> {
           new Passenger("2222","John Smith","GJ");
        });
    }

    @Test
    public void testPassengerToString(){
        Passenger passenger = new Passenger("1111","John Smith","US");
        assertEquals("Passenger John Smith with identifier: 1111 from US", passenger.toString());
    }

}