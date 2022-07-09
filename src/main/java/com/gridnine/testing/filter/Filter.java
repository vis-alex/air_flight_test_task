package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * @author Alexand Usenko
 * @version 1.0
 * @since 1.0
 * Base Filter interface
 * */
public interface Filter {
    /**
     * This method must get list of {@link Flight} instances and filter its
     * @param flights - not filtered list of {@link Flight}
     * @return filtered list of {@link Flight} by some conditions
     * */
    List<Flight> filter(List<Flight> flights);
}
