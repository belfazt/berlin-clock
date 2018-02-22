import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ClockTest {
  private Clock clock;

  @Before
  public void setUp() {
    this.clock = new Clock();
  }

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void throwsIllegalArgumentExceptionIfHoursAreGreaterThanTwentyThree() {
    exception.expect(IllegalArgumentException.class);
    new Clock(24, 0, 0);
  }

  @Test
  public void throwsIllegalArgumentExceptionIfMinutesAreGreaterThanFiftyNine() {
    exception.expect(IllegalArgumentException.class);
    new Clock(0, 60, 0);
  }

  @Test
  public void throwsIllegalArgumentExceptionIfSecondsAreGreaterThanFiftyNine() {
    exception.expect(IllegalArgumentException.class);
    new Clock(0, 0, 60);
  }

  @Test
  public void throwsIllegalArgumentExceptionIfHoursAreLessThanZero() {
    exception.expect(IllegalArgumentException.class);
    new Clock(-1, 0, 0);
  }

  @Test
  public void throwsIllegalArgumentExceptionIfMinutesAreLessThanZero() {
    exception.expect(IllegalArgumentException.class);
    new Clock(0, -1, 0);
  }

  @Test
  public void throwsIllegalArgumentExceptionIfSecondsAreLessThanZero() {
    exception.expect(IllegalArgumentException.class);
    new Clock(0, 0, -1);
  }

  @Test
  public void displaysTheHourCorrectly() {
    Assert.assertEquals("00:00:00", this.clock.toString());
  }

  @Test
  public void ticksCorrectly() {
    this.clock.setTime(23,59, 59);
    this.clock.tick();
    Assert.assertEquals(0, this.clock.getHours());
    Assert.assertEquals(0, this.clock.getMinutes());
    Assert.assertEquals(0, this.clock.getSeconds());
    Assert.assertEquals("00:00:00", this.clock.toString());

    this.clock.tick();
    Assert.assertEquals(0, this.clock.getHours());
    Assert.assertEquals(0, this.clock.getMinutes());
    Assert.assertEquals(1, this.clock.getSeconds());
    Assert.assertEquals("00:00:01", this.clock.toString());

    this.clock.setTime(5,59,59);
    this.clock.tick();
    Assert.assertEquals(6, this.clock.getHours());
    Assert.assertEquals(0, this.clock.getMinutes());
    Assert.assertEquals(0, this.clock.getSeconds());
    Assert.assertEquals("06:00:00", this.clock.toString());

    this.clock.setTime(8,58,59);
    this.clock.tick();
    Assert.assertEquals(8, this.clock.getHours());
    Assert.assertEquals(59, this.clock.getMinutes());
    Assert.assertEquals(0, this.clock.getSeconds());
    Assert.assertEquals("08:59:00", this.clock.toString());
  }
}
