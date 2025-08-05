package com.beck;

import java.util.Arrays;
import java.util.Locale;

public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)){
            throw new RuntimeException("Invalid country code: " + countryCode);
        }
        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void joinFlight(Flight flight) {
        Flight oldFlight = this.flight;
        if (oldFlight != null) {
            if (!oldFlight.removePassenger(this)) {
                throw new RuntimeException("Failed to remove passenger from the flight");
            }
        }
        setFlight(flight);
        if (flight != null) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Failed to add passenger to the flight");
            }
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return "Passenger " + getName()+ " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
