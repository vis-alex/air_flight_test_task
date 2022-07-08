package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.FlightCombineFilter;
import com.gridnine.testing.model.Flight;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static test_data.FlightTestData.*;

public class FilterTest {

    private FlightCombineFilter combineFilter;

    @Before
    public void setUp() throws Exception {
        combineFilter = new FlightCombineFilter();
        combineFilter.setFlights(FLIGHTS);
    }

    @Test
    public void arrivalBeforeDepartureFilterTest() {
        combineFilter.addFilter(ARRIVAL_BEFORE_DEPARTURE_FILTER);
        List<Flight> actualFlights = combineFilter.applyFilters();

        assertEquals(3, actualFlights.size());
        assertEquals(Arrays.asList(FLIGHT_1, FLIGHT_2, FLIGHT_4), actualFlights);
    }

    @Test
    public void departureBeforeNowFilter() {
        combineFilter.addFilter(DEPARTURE_BEFORE_NOW_FILTER);
        List<Flight> actualFlights = combineFilter.applyFilters();

        assertEquals(2, actualFlights.size());
        assertEquals(Arrays.asList(FLIGHT_1, FLIGHT_2), actualFlights);
    }

    @Test
    public void moreThanTwoHoursGroundFilter() {
        combineFilter.addFilter(MORE_THAN_TWO_HOURS_FILTER);
        List<Flight> actualFlights = combineFilter.applyFilters();

        assertEquals(3, actualFlights.size());
        assertEquals(Arrays.asList(FLIGHT_1, FLIGHT_2, FLIGHT_3), actualFlights);
    }

    @Test
    public void applyMultipleFilters() {
        combineFilter.addFilter(MORE_THAN_TWO_HOURS_FILTER);
        combineFilter.addFilter(DEPARTURE_BEFORE_NOW_FILTER);
        combineFilter.addFilter(ARRIVAL_BEFORE_DEPARTURE_FILTER);
        List<Flight> actualFlights = combineFilter.applyFilters();

        assertEquals(2, actualFlights.size());
        assertEquals(List.of(FLIGHT_1, FLIGHT_2), actualFlights);
    }
}

