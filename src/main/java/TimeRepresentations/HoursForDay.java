package TimeRepresentations;

import java.time.Duration;
import java.util.Objects;

public class HoursForDay {
    public Duration HoursForDay;

    public HoursForDay(int hours, int minutes){
        int hoursToMinutes = hours *60;
        HoursForDay = Duration.ofMinutes(hoursToMinutes + minutes);
    }

    public HoursForDay(long minutes) {
        HoursForDay = Duration.ofMinutes(minutes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoursForDay that = (HoursForDay) o;
        return HoursForDay.equals(that.HoursForDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HoursForDay);
    }
}
