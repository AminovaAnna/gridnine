package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {
    private final LocalDateTime depDate;

    private final LocalDateTime arrDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        depDate = Objects.requireNonNull(dep);
        arrDate = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepDate() {
        return depDate;
    }

    LocalDateTime getArrDate() {
        return arrDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + depDate.format(fmt) + '|' + arrDate.format(fmt)
                + ']';
    }
}
