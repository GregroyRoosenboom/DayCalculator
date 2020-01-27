package TimeRepresentations;

import java.time.Duration;
import java.util.ArrayList;

public class TimeRegistrationsPeriod {

    private ArrayList<Day> days;

    public TimeRegistrationsPeriod() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
      days.add(day);
    }

    public void calculate() {
        for (Day day: days) {
            day.calculate();
        }
    }

    public Duration getOvertime() {
        Duration overtimeForPeriod = Duration.ofMinutes(0);
        for (Day day :days) {
            overtimeForPeriod = overtimeForPeriod.plus(day.getOvertime());
        }
        return overtimeForPeriod;
    }
}
