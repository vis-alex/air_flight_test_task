package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(
                        flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
