import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ClockTest.class,
    BerlinClockTest.class,
    LightTest.class
})
public class TestSuite {
}
