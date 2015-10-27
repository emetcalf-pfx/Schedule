package com.metcalf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ScheduleTest {
    private Schedule schedule;

    @Before
    public void setUp() throws Exception {
        schedule = new Schedule(new ArrayList<Shift>(Arrays.asList(Constants.A_SHIFTS)), Constants.SHIFTS_START_DATE);
    }

    @Test
    public void testGetShiftByDaysSincePassed_firstDay() {
        assertEquals(Shift.DAY, schedule.getShiftByDaysSincePassed(0));
    }

    @Test
    public void testGetShiftByDaysSincePassed_night() {
        assertEquals(Shift.NIGHT, schedule.getShiftByDaysSincePassed(11));
    }

    @Test
    public void testGetShiftByDaysSincePassed_lastDay() {
        assertEquals(Shift.OFF, schedule.getShiftByDaysSincePassed(27));
    }
    
    @Test
    public void testGetShiftByDaysSincePassed_firstWrappedDay() {
        assertEquals(Shift.DAY, schedule.getShiftByDaysSincePassed(28));
    }
    
    @Test
    public void testGetShiftByDaysSincePassed_secondWrappedDay() {
        assertEquals(Shift.DAY, schedule.getShiftByDaysSincePassed(56));
    }
    
    @Ignore("Don't support past days yet.")
    @Test
    public void testGetShiftByDaysSincePassed_dayInPast() {
        assertEquals(Shift.OFF, schedule.getShiftByDaysSincePassed(-4));
    }
    
    @Test
    public void testGetShiftByDate() {
        assertEquals(Shift.DAY, schedule.getShiftByDate(new LocalDate(2015, 12, 01)));
    }
    
}
