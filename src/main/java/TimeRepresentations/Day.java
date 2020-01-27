package TimeRepresentations;

import Calculators.HoursForDaysCalculator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Day {
    private final ArrayList<Booking> bookings;
    public Duration FullTime;
    public Duration BreakTime;
    public Duration TakenBreak;
    public Duration WorkedTime;
    public boolean isCalculated;
    public boolean WorkedFullDay;

    public Day(){

        bookings = new ArrayList<Booking>();
        isCalculated = false;
        WorkedFullDay =true;
        TakenBreak = Duration.ofMinutes(0);

    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean workedTimeLongerThanHalfDay(HoursForDay unReducedHours) {
        return WorkedFullDay;
    }

    public Duration getOvertime() {
         HoursForDaysCalculator.CalculateHours(this);
         return WorkedFullDay ?
                 WorkedTime.minusMinutes(FullTime.toMinutes()) :
                 WorkedTime.minusMinutes(FullTime.toMinutes()/2);
    }

    public void calculate() {
        HoursForDaysCalculator.CalculateHours(this);
    }
}
