package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class MoreTwoHoursOnGroundFilter implements FlightFilter{


    @Override
    public List<Flight> flightFilter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    if (segments.size() <= 1) {
                        return false; // Недостаточно сегментов для проверки интервала
                    }
                    for (int i = 0; i < segments.size() - 1; i++) {
                        Segment currentSegment = segments.get(i);
                        Segment nextSegment = segments.get(i + 1);
                        // Проверка, что время прибытия текущего сегмента
                        // меньше времени вылета следующего сегмента на 2 часа
                        if (currentSegment.getArrDate().plusHours(2).isBefore(nextSegment.getDepDate())) {
                            return false; // Интервал меньше 2 часов
                        }
                    }
                    return true; // Все интервалы больше 2 часов
                })
                .toList();
    }
//    @Override
//    public List<Flight> flightFilter(List<Flight> flights) {
//        LocalDateTime now = LocalDateTime.now();
//        return flights.stream()
//                .filter(flight -> flight.getSegments().stream()
//                        .allMatch(segment -> segment.getArrDate().)
//                )
//    }
}
