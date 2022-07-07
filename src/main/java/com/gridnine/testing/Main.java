package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> flights =  FlightBuilder.createFlights();

        System.out.println(flights.size());

        List<Flight> filteredFlights = filter.filter(flights);
        System.out.println(filteredFlights.size());
    }
}