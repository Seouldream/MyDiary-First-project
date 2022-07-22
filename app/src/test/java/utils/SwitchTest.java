package utils;

import jdk.swing.interop.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SwitchTest {
  @Test
  void switchTest() {
    Switch switchButton = new Switch();

    assertEquals("OFF", switchButton.state());
    switchButton.ON();
    assertEquals("ON",switchButton.state());
  }

}