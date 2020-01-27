package TimeRepresentations;

import java.time.LocalTime;

public class Booking {
    public LocalTime Time;

    public Booking(int hours, int minutes) {
        Time = LocalTime.of(hours, minutes);
    }
}
