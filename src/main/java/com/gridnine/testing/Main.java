package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();


        System.out.println("1. Исходные тестовые данные без фильтров:" + flights);


//        FlightFilter groundTimeMoreThanTwoHoursFilter = new GroundTimeMoreThanTwoHoursFilter();
//        List<Flight> filteredFlightsByGroundTimeMoreThanTwoHours = groundTimeMoreThanTwoHoursFilter.filterFlights(flights);
//        System.out.println("Включен фильтр по общему времени на земле более двух часов: "
//                + filteredFlightsByGroundTimeMoreThanTwoHours);
        FlightFilter depBeforeNow = new DepBeforeNowFilter();
        List <Flight> filterDepBeforeNow = depBeforeNow.flightFilter(flights);
        System.out.println("2. Фильтрация по вылету до настоящего времени:" + filterDepBeforeNow);

        FlightFilter arrBeforeDep = new ArrBeforeDepFilter();
        List <Flight> filterArrBeforeDep = arrBeforeDep.flightFilter(flights);
        System.out.println("3. Фильтрация прилет раньше вылета:" + filterArrBeforeDep);

        FlightFilter moreTwoHoursOnGround = new MoreTwoHoursOnGroundFilter();
        List<Flight> filterMoreTwoHoursOnGround = moreTwoHoursOnGround.flightFilter(flights);
        System.out.println("4. Фильтрация по времени на земле более 2 часов" + filterMoreTwoHoursOnGround);

    }
}
