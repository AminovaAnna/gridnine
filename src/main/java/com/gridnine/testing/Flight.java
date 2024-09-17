package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    public final List<Segment> segments;

    Flight(final List<Segment> segmentList) {
        segments = segmentList;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }


/**
 * Bean that represents a flight segment.
 */
}
