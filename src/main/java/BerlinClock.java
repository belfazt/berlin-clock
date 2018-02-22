public class BerlinClock extends Clock {

  private static final Light[] FOURTH_ROW_PATTERN = new Light[]{ Light.YELLOW, Light.YELLOW, Light.RED };

  public BerlinClock(int hours, int minutes, int seconds) {
    super(hours, minutes, seconds);
  }

  public BerlinClock() {
    this(0, 0, 0);
  }

  public String toString() {
    return firstRow() + "\n" +
        secondRow() + "\n" +
        thirdRow() + "\n" +
        fourthRow() + "\n" +
        fifthRow() + "\n";
  }

  private String firstRow() {
    return this.getSeconds() % 2 == 0 ? Light.YELLOW.character() : Light.OFF.character();
  }

  private String secondRow() {
    return generateRow(4, this.getHours() / 5, Light.RED);
  }

  private String thirdRow() {
    return generateRow(4, Math.max(0, this.getHours() - 20), Light.RED);
  }

  private String fourthRow() {
    return generateRow(11, this.getMinutes() / 5, FOURTH_ROW_PATTERN);
  }

  private String fifthRow() {
    return generateRow(4, this.getMinutes() % 5, Light.YELLOW);
  }

  private String generateRow(int size, int rule, Light light) {
    return generateRow(size, rule, new Light[] { light });
  }

  private String generateRow(int size, int rule, Light[] lightsPattern) {
    StringBuilder row = new StringBuilder();

    for (int i = 0; i < rule; i++) {
      row.append(lightsPattern[i % lightsPattern.length].character());
    }

    for (int i = rule; i < size; i++) {
      row.append(Light.OFF.character());
    }

    return row.toString();
  }
}
