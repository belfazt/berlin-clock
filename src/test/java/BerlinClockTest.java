import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {
  private BerlinClock clock;

  @Before
  public void setUp() {
    this.clock = new BerlinClock();
  }

  @Test
  public void testShowsTenThirtyOneWithZeroSeconds() {
    String tenThirtyOne = "Y\n" +
        "RRXX\n" +
        "XXXX\n" +
        "YYRYYRXXXXX\n" +
        "YXXX\n";

    this.clock.setTime(10, 31, 0);

    Assert.assertEquals(tenThirtyOne, this.clock.toString());
  }

  @Test
  public void testShowsTenThirtyOneWithOneSecond() {
    String tenThirtyOne = "X\n" +
        "RRXX\n" +
        "XXXX\n" +
        "YYRYYRXXXXX\n" +
        "YXXX\n";

    this.clock.setTime(10, 31, 1);

    Assert.assertEquals(tenThirtyOne, this.clock.toString());
  }

  @Test
  public void testThatItIsAbleToTick() {
    String tenThirtyOne = "X\n" +
        "RRXX\n" +
        "XXXX\n" +
        "YYRYYRXXXXX\n" +
        "YXXX\n";

    this.clock.setTime(10, 31, 1);

    Assert.assertEquals(tenThirtyOne, this.clock.toString());

    this.clock.tick();

    tenThirtyOne = "Y\n" +
        "RRXX\n" +
        "XXXX\n" +
        "YYRYYRXXXXX\n" +
        "YXXX\n";

    Assert.assertEquals(tenThirtyOne, this.clock.toString());
  }
}
