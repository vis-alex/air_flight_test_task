package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.MoreThanTwoHoursBetweenArrivalAndDepartureFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filter filter;
        List<Flight> filteredFlights;
        List<Flight> flights =  FlightBuilder.createFlights();
        System.out.println(
                "Unfiltered flights: " + flights.size()
        );

//        filter = new ArrivalBeforeDepartureFilter();
//        filteredFlights = filter.filter(flights);
//        System.out.println(
//                "Flights filtered by ArrivalBeforeDepartureFilter: " + filteredFlights.size()
//        );

        filter = new MoreThanTwoHoursBetweenArrivalAndDepartureFilter();
        filteredFlights = filter.filter(flights);
        System.out.println(
                "Flights filtered by MoreThanTwoHoursBetweenArrivalAndNextDepartureFilter: " + filteredFlights.size()
        );
    }
}