package com.metcalf;

import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Schedule {
    private final List<Shift> shifts;
    private final LocalDate startOfShifts;

    public Schedule(List<Shift> shifts, LocalDate startOfShifts) {
        this.shifts = shifts;
        this.startOfShifts = startOfShifts;
    }

    public Shift getShiftByDaysSincePassed(int days) {
        return shifts.get(days % shifts.size());
    }

    public Shift getShiftByDate(LocalDate date) {
        int daysSincePassed = Days.daysBetween(startOfShifts, date).getDays();
        return getShiftByDaysSincePassed(daysSincePassed);
    }

}
