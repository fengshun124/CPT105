/*
 * CW1 Week 6, to be used again in Week 7
 * Complete using your codes in Week 6 or the solutions
 *
 */

public class Clock {
    private int hours;
    private int minutes;

    // CW1 6.1
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        hours = h;
        minutes = m;
    }

    // CW1 6.2
    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        hours = h;
        minutes = m;
    }

    // CW1 6.3
    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String output = "";
        if (hours < 10) output = "0" + hours;
        else output += hours;
        if (minutes < 10) output += ":0" + minutes;
        else output += ":" + minutes;
        return output;
    }

    // CW1 6.4
    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) return true;
        else if (hours == that.hours && minutes < that.minutes) return true;
        return false;
    }

    // CW1 6.5
    // Adds 1 minute to the time on this clock.
    public void tick() {
        minutes++;
        if (minutes == 60) {
            hours++;
            minutes = 0;
            if (hours == 24)
                hours = 0;
        }
    }

    // CW1 6.6
    // Adds delta minutes to the time on this clock.
    public void tock(int delta) {
        int deltaHours = delta / 60;
        int deltaMinutes = delta % 60;
        hours = (hours + deltaHours) % 24;
        minutes += deltaMinutes;
        if (minutes >= 60) {
            hours++;
            minutes %= 60;
            if (hours == 24) hours = 0;
        }
    }

    // Getters
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

}
