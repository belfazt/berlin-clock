# Berlin Clock

## Purpose
Represent a [Berlin Clock](https://en.wikipedia.org/wiki/Mengenlehreuhr) within a JVM language

## Building
```bash
$ ./gradlew assemble
# Starting a Gradle Daemon, 1 stopped Daemon could not be reused, use --status for details
# :compileJava
# :processResources NO-SOURCE
# :classes
# :jar
# :assemble

# BUILD SUCCESSFUL

```

## Running Tests
```bash
$ ./gradlew test
# :compileJava UP-TO-DATE
# :processResources NO-SOURCE
# :classes UP-TO-DATE
# :compileTestJava
# :processTestResources NO-SOURCE
# :testClasses
# :test
# :jacocoTestReport

# BUILD SUCCESSFUL

# Total time: 2.284 secs
```

### Coverage Reports
These get generated in the following path `./build/reports/jacoco/test`

## Examples
```java
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

```

# Contributors

- Diego Camargo
