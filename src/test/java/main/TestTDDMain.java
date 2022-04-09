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

    @Test
    @DisplayName("Test Add Method with two numbers")
    public void testAddMethodTwoNumbers() {
      int result = ttdmainObj.add("5, 4");
      assertEquals(9, result, "Expected add method to return the sum of the numbers");
    }

    @Test
    @DisplayName("Test Add Method with multiple numbers")
    public void testAddMethodMultipleNumbers() {
      int result = ttdmainObj.add("5, 4, 6, 8, 15, 31");
      assertEquals(69, result, "Expected add method to return the sum of all the numbers");
    }

    @Test
    @DisplayName("Test Add Method with newline as delimiter")
    public void testAddMethodHandleNewlineAsDelimiter() {
      int result = ttdmainObj.add("5, 4, 6\n 8, 15\n 31");
      assertEquals(69, result, "Expected add method to return the sum of all the numbers");
    }

    @Test
    @DisplayName("Test Add Method with custom delimiter")
    public void testAddMethodHandleCustomDelimiter() {
      int result = ttdmainObj.add("//;\n1;2");
      assertEquals(3, result, "Expected add method to use custom delimiter and return the sum of all the numbers");
    }
  }
}
