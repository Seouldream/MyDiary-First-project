package utils;

public class Switch {
  private static String ON = "ON";
  private static String OFF = "OFF";
  private String state;

  public Switch() {
    this.state = Switch.OFF;
  }

  public void ON() {
    state = Switch.ON;
  }

  public String state() {
    return state;
  }

}
