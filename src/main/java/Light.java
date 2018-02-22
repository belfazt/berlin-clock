enum Light {
  RED("R"),
  YELLOW("Y"),
  OFF("X");

  private final String color;

  Light(String color) {
    this.color = color;
  }

  public String character() {
    return this.color;
  }
}