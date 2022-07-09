package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Filter implementation for filtering list of {@link Flight} by condition: Departure must be before arrival
 * */
public class ArrivalBeforeDepartureFilter implements Filter {

    /**
     * This method remove all {@link Flight} from the list, which have segments  with departure date happened
     * after arrival date
     ** @param flights - not filtered list of {@link Flight}
     *  @return filtered list of {@link Flight}
     * */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(
                        flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
