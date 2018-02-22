import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Clock {
  private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("00");
  private int hours;
  private int minutes;
  private int seconds;

  public Clock() {
    this(0, 0, 0);
  }

  public Clock(int hours, int minutes, int seconds) {
    this.setTime(hours, minutes, seconds);
  }

  public void setTime(int hours, int minutes, int seconds) {
    this.setHours(hours);
    this.setMinutes(minutes);
    this.setSeconds(seconds);
  }

  public int getSeconds() {
    return this.seconds;
  }

  public int getMinutes() {
    return this.minutes;
  }

  public int getHours() {
    return this.hours;
  }

  public void tick() {
    this.seconds += 1;
    if (this.seconds == 60) {
      this.seconds = 0;
      tickMinutes();
    }
  }

  // Private methods

  private void tickMinutes() {
    this.minutes += 1;
    if (this.minutes == 60) {
      this.minutes = 0;
      tickHours();
    }
  }

  private void tickHours() {
    this.hours += 1;
    if (this.hours == 24) {
      this.hours = 0;
    }
  }

  private void setHours(int hours) {
    if (hours > 23 || hours < 0) throw new IllegalArgumentException();
    this.hours = hours;
  }

  private void setMinutes(int minutes) {
    if (minutes > 59 || minutes < 0) throw new IllegalArgumentException();
    this.minutes = minutes;
  }

  private void setSeconds(int seconds) {
    if (seconds > 59 || seconds < 0) throw new IllegalArgumentException();
    this.seconds = seconds;
  }

  public String toString() {
    return NUMBER_FORMAT.format(getHours()) + ":" + NUMBER_FORMAT.format(getMinutes()) + ":" + NUMBER_FORMAT.format(getSeconds());
  }
}
