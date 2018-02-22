import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {

    BerlinClock clock = new BerlinClock(10, 31, 0);

    System.out.println(clock); // Outputs the following
    // Y
    // RRXX
    // XXXX
    // YYRYYRXXXXX
    // YXXX

    // Make the clock go forward five minutes
    IntStream.range(0, 60 * 5).forEach(i -> clock.tick());

    System.out.println(clock); // Outputs the following
    // Y
    // RRXX
    // XXXX
    // YYRYYRYXXXX
    // YXXX
  }
}
