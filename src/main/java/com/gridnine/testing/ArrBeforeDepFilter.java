package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ArrBeforeDepFilter implements FlightFilter{
    @Override
    public List<Flight> flightFilter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment-> segment.getDepDate().isBefore(segment.getArrDate()))
                        )
                        .collect(Collectors.toList());
    }
}
