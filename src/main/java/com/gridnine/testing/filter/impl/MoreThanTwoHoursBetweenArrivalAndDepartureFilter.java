package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThanTwoHoursBetweenArrivalAndDepartureFilter implements Filter {
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

    public long hoursBetweenArrivalAndDeparture(LocalDateTime arrival, LocalDateTime departure) {
        return ChronoUnit.HOURS.between(arrival, departure);
    }
}
