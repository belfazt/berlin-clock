import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LightTest {
  @Test
  public void testValueOf() {
    assertEquals(Light.YELLOW, Light.valueOf("YELLOW"));
    assertEquals(Light.RED, Light.valueOf("RED"));
    assertEquals(Light.OFF, Light.valueOf("OFF"));
  }
}
