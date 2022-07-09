package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Model for entity Flight which contains list of {@link Segment} entities
 * */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "Flight: " + segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
