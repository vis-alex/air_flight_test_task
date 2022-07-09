package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Filter implementation for filtering list of {@link Flight} by condition: Departure must be after current moment.
 * */
public class DepartureBeforeNowFilter implements Filter {

    /**
     * This method remove all {@link Flight} from the list, which have segments  with departure date was happened
     * before current moment
     ** @param flights - not filtered list of {@link Flight}
     *  @return filtered list of {@link Flight}
     * */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(
                        flight -> flight.getSegments().stream()
                                .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
                )
                .collect(Collectors.toList());
    }
}
