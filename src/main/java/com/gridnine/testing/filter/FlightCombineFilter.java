package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Pattern Strategy implementation for multi-usage filters {@link Filter} on list of {@link Flight}
 * For correct working filters and flights are transmitted from outside
 * */
public class FlightCombineFilter {
    private List<Filter> filters = new ArrayList<>();
    private List<Flight> flights;

    public FlightCombineFilter(List<Flight> flights) {
        this.flights = flights;
    }

    public FlightCombineFilter(List<Filter> filters, List<Flight> flights) {
        this.filters = filters;
        this.flights = flights;
    }

    public FlightCombineFilter(List<Filter> filters, Flight ... flights) {
        this.filters = filters;
        this.flights = Arrays.asList(flights);
    }

    /**
     * Add single filter
     * */
    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    /**
     * Remove single filter
     * */
    public void removeFilter(Filter filter) {
        filters.remove(filter);
    }

    public List<Flight> getFlights() {
        return List.copyOf(flights);
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Filter> getFilters() {
        return List.copyOf(filters);
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void setFilters(Filter ... filters) {
        this.filters = Arrays.asList(filters);
    }

    /**
     * This method applies all filters from the {@link FlightCombineFilter#filters}
     * to the {@link FlightCombineFilter#flights} in turn
     * @return filtered list of {@link Flight}
     * */
    public List<Flight> applyFilters() {
        List<Flight> result = new ArrayList<>(flights);

        for (Filter filter : filters) {
            result = filter.filter(result);
        }

        return result;
    }
}
