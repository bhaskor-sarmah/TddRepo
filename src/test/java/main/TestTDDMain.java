package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTDDMain {

  public static class TestAddMethod {

    private static TDDMain ttdmainObj;

    @BeforeAll
    public static void testSetup() {
      ttdmainObj = new TDDMain();
    }

    @Test
    @DisplayName("Test Add Method with empty string")
    public void testAddEmptyString() {
      int result = ttdmainObj.add("");
      assertEquals(0, result, "Expected add method to return 0");
    }

    @Test
    @DisplayName("Test Add Method with single number")
    public void testAddMethodSingleNumber() {
      int result = ttdmainObj.add("5");
      assertEquals(5, result, "Expected add method to return the same number");
    }

  }
}
