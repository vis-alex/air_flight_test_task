package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightCombineFilter {
    private List<Filter> filters = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

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

    public List<Flight> applyFilters() {
        List<Flight> result = new ArrayList<>(flights);

        for (Filter filter : filters) {
            result = filter.filter(result);
        }

        return result;
    }
}
