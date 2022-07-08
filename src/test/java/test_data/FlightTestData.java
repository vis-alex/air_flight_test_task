package test_data;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.impl.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filter.impl.DepartureBeforeNowFilter;
import com.gridnine.testing.filter.impl.MoreThanTwoHoursBetweenArrivalAndDepartureFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightTestData {
    public static final Filter ARRIVAL_BEFORE_DEPARTURE_FILTER = new ArrivalBeforeDepartureFilter();
    public static final Filter DEPARTURE_BEFORE_NOW_FILTER = new DepartureBeforeNowFilter();
    public static final Filter MORE_THAN_TWO_HOURS_FILTER = new MoreThanTwoHoursBetweenArrivalAndDepartureFilter();

    public static final LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    //Normal segments
    public static final Segment SEGMENT_1 = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    public static final Segment SEGMENT_2 = new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4));
    public static final Segment SEGMENT_3 = new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(8));

    //Segments departing in the past
    public static final Segment SEGMENT_4 = new Segment(threeDaysFromNow.minusDays(5), threeDaysFromNow.minusHours(5));

    //A segment departing in the past and arrived before departure
    public static final Segment SEGMENT_5 = new Segment(threeDaysFromNow.minusDays(5), threeDaysFromNow.minusDays(6));

    //Normal flights
    public static final Flight FLIGHT_1 = new Flight(Arrays.asList(SEGMENT_1, SEGMENT_2, SEGMENT_3));
    public static final Flight FLIGHT_2 = new Flight(Arrays.asList(SEGMENT_2, SEGMENT_3));
    //A flight that arrives earlier than it left and departure in the past more than two hours ground time
    public static final Flight FLIGHT_3 = new Flight(Collections.singletonList(SEGMENT_5));
    //A flight with more than two hours ground time
    public static final Flight FLIGHT_4 = new Flight(Arrays.asList(SEGMENT_4, SEGMENT_1));

    public static final List<Flight> FLIGHTS = List.of(FLIGHT_1, FLIGHT_2, FLIGHT_3, FLIGHT_4);
}
