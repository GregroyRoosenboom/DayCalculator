package Calculators;

import TimeRepresentations.Booking;
import TimeRepresentations.Day;
import TimeRepresentations.HoursForDay;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class HoursForDaysCalculator {

    public static void CalculateHours(Day day) {
        if (day.isCalculated){ return; } else {calculateDay(day);}

        day.isCalculated = true;
    }

    private static void calculateDay(Day day) {
        List<Booking> bookings = day.getBookings();
        Duration unReducedHours = calculateWorkedHoursAndBreakTaken(day);
        if (workedLongerThanHalfADay(day) && breakWasBooked(day)){
            deductBreakFromWorkedTime(day, unReducedHours);
        }
        else {
            day.WorkedTime = unReducedHours;
        }
    }

    private static void deductBreakFromWorkedTime(Day day, Duration unReducedHours) {
        if (unReducedHours.isZero()) {
            day.WorkedTime = unReducedHours;
            return;
        }

        day.WorkedTime = unReducedHours.minus(day.BreakTime.minus(day.TakenBreak));
    }

    private static boolean breakWasBooked(Day day) {
        return day.TakenBreak.compareTo(day.BreakTime)< 0;
    }

    private static boolean workedLongerThanHalfADay(Day day) {
        return day.WorkedFullDay;
    }

    private static Duration calculateWorkedHoursAndBreakTaken(Day day) {
            int numberOfBookings = day.getBookings().size();
            Duration hours = Duration.ofMinutes(0);
            int i = 0;
                List<Booking> bookings = day.getBookings();
                while (i < numberOfBookings) {
                    if (numberOfBookings> i+1){
                        hours= hours.plusMinutes(bookings.get(i).Time.until(bookings.get(i+1).Time, MINUTES));
                    }
                    if (numberOfBookings > i+2){
                        day.TakenBreak = day.TakenBreak.plusMinutes(bookings.get(i+1).Time.until(bookings.get(i+2).Time, MINUTES));
                    }
                    i = i+2;
                }
            return hours;
    }
}
