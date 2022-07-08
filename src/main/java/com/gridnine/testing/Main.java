package com.gridnine.testing;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.FlightCombineFilter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.impl.MoreThanTwoHoursBetweenArrivalAndDepartureFilter;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Filter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        Filter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        Filter moreThanTwoHoursFilter = new MoreThanTwoHoursBetweenArrivalAndDepartureFilter();

        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> filteredFlights;

        FlightCombineFilter flightCombineFilter = new FlightCombineFilter();
        flightCombineFilter.setFlights(flights);

        System.out.println(
                "Unfiltered flights: " + flights.size() +
                        "\n" + "Flights list: " + flights + "\n"
        );

        flightCombineFilter.addFilter(arrivalBeforeDepartureFilter);
        filteredFlights = flightCombineFilter.applyFilters();
        System.out.println(
                "Flights filtered by ArrivalBeforeDepartureFilter: " + filteredFlights.size() +
                        "\n" + "Flights list: " + filteredFlights + "\n"
        );
        flightCombineFilter.removeFilter(arrivalBeforeDepartureFilter);

        flightCombineFilter.addFilter(departureBeforeNowFilter);
        filteredFlights = flightCombineFilter.applyFilters();
        System.out.println(
                "Flights filtered by DepartureBeforeNowFilter: " + filteredFlights.size() +
                        "\n" + "Flights list: " + filteredFlights + "\n"
        );
        flightCombineFilter.removeFilter(departureBeforeNowFilter);

        flightCombineFilter.addFilter(moreThanTwoHoursFilter);
        filteredFlights = flightCombineFilter.applyFilters();
        System.out.println(
                "Flights filtered by MoreThanTwoHoursBetweenArrivalAndDepartureFilter: " + filteredFlights.size() +
                        "\n" + "Flights list: " + filteredFlights + "\n"
        );
        flightCombineFilter.removeFilter(moreThanTwoHoursFilter);


        //Second, simpler variant, without multiple filters

//        Filter filter;
//        List<Flight> filteredFlights;
//        List<Flight> flights =  FlightBuilder.createFlights();
//        System.out.println(
//                "Unfiltered flights: " + flights.size() +
//                        "\n" + "Flights list: " + flights + "\n"
//        );
////
//        filter = new ArrivalBeforeDepartureFilter();
//        filteredFlights = filter.filter(flights);
//        System.out.println(
//                "Flights filtered by ArrivalBeforeDepartureFilter: " + filteredFlights.size() +
//                        "\n" + "Flights list: " + filteredFlights + "\n"
//        );
//
//        filter = new MoreThanTwoHoursBetweenArrivalAndDepartureFilter();
//        filteredFlights = filter.filter(flights);
//        System.out.println(
//                "Flights filtered by MoreThanTwoHoursBetweenArrivalAndDepartureFilter: " + filteredFlights.size() +
//                        "\n" + "Flights list: " + filteredFlights + "\n"
//        );
//
//        filter = new DepartureBeforeNowFilter();
//        filteredFlights = filter.filter(flights);
//        System.out.println(
//                "Flights filtered by DepartureBeforeNowFilter: " + filteredFlights.size() +
//                        "\n" + "Flights list: " + filteredFlights + "\n"
//        );
    }
}