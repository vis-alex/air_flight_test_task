package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Filter implementation for filtering list of {@link Flight} by condition: The plain must be on the ground less two hours
 * between segments of it`s flight
 * */
public class MoreThanTwoHoursBetweenArrivalAndDepartureFilter implements Filter {
    /**
     * This method remove all {@link Flight} from the list, which have time interval between segments
     * (between arrival of the one and departure of the next {@link Segment}) more than two hours
     ** @param flights - not filtered list of {@link Flight}
     *  @return filtered list of {@link Flight}
     * */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(
                        flight -> {
                            List<Segment> segments = flight.getSegments();
                            if (segments.size() > 1) {
                                for (int i = 0; i < segments.size() - 1; i++) {
                                    if (hoursBetweenArrivalAndDeparture(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()) > 2) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                )
                .collect(Collectors.toList());
    }

    /**
     * This method compute time interval between two dates
     * @param arrival - date and time  of arrival first {@link Segment}
     * @param departure - date and time of departure next {@link Segment}
     * */
    public long hoursBetweenArrivalAndDeparture(LocalDateTime arrival, LocalDateTime departure) {
        return ChronoUnit.HOURS.between(arrival, departure);
    }
}
