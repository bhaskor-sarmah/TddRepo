package main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTDDMain {

  public static class TestAddMethod {

    private static TDDMain ttdmainObj;

    @BeforeAll
    public static void testSetup() {
      ttdmainObj = new TDDMain();
    }

    @Test
    @DisplayName("Test Add Method with empty string")
    public void testAddEmptyString() throws Exception {
      int result = ttdmainObj.add("");
      assertEquals(0, result, "Expected add method to return 0");
    }

    @Test
    @DisplayName("Test Add Method with single number")
    public void testAddMethodSingleNumber() throws Exception {
      int result = ttdmainObj.add("5");
      assertEquals(5, result, "Expected add method to return the same number");
    }

    @Test
    @DisplayName("Test Add Method with two numbers")
    public void testAddMethodTwoNumbers() throws Exception {
      int result = ttdmainObj.add("5, 4");
      assertEquals(9, result, "Expected add method to return the sum of the numbers");
    }

    @Test
    @DisplayName("Test Add Method with multiple numbers")
    public void testAddMethodMultipleNumbers() throws Exception {
      int result = ttdmainObj.add("5, 4, 6, 8, 15, 31");
      assertEquals(69, result, "Expected add method to return the sum of all the numbers");
    }

    @Test
    @DisplayName("Test Add Method with newline as delimiter")
    public void testAddMethodHandleNewlineAsDelimiter() throws Exception {
      int result = ttdmainObj.add("5, 4, 6\n 8, 15\n 31");
      assertEquals(69, result, "Expected add method to return the sum of all the numbers");
    }

    @Test
    @DisplayName("Test Add Method with custom delimiter")
    public void testAddMethodHandleCustomDelimiter() throws Exception {
      int result = ttdmainObj.add("//;\n1;2");
      assertEquals(3, result, "Expected add method to use custom delimiter and return the sum of all the numbers");
    }

    @Test
    @DisplayName("Test Add Method with negative number")
    public void testAddMethodHandleNegativeNumber() {
      Exception exception = assertThrows(Exception.class, () -> {
        ttdmainObj.add("-1");
      });

      String expectedMessage = "Negatives not allowed : [-1]";
      String actualMessage = exception.getMessage();

      assertTrue(actualMessage.equals(expectedMessage), "Expected an Exception to be thrown with custom message");
    }

    @Test
    @DisplayName("Test Add Method with negative numbers")
    public void testAddMethodHandleNegativeNumbers() {
      Exception exception = assertThrows(Exception.class, () -> {
        ttdmainObj.add("//;\n-1;-2");
      });

      String expectedMessage = "Negatives not allowed : [-1, -2]";
      String actualMessage = exception.getMessage();

      assertTrue(actualMessage.equals(expectedMessage), "Expected an Exception to be thrown with custom message and the numbers");
    }

    @Test
    @DisplayName("Test Add Method handle NumberFormatException")
    public void testAddMethodHandleNumberFormatException() {
      Exception exception = assertThrows(NumberFormatException.class, () -> {
        ttdmainObj.add("a, b");
      });

      String expectedMessage = "Invalid String Received : [a,  b]";
      String actualMessage = exception.getMessage();
      assertTrue(actualMessage.equals(expectedMessage), "Expected an NumberFormatException to be thrown with custom message");
    }

    @Test
    @DisplayName("Test Add Method handle Invalid Pattern")
    public void testAddMethodHandleInvalidPattern() {
      Exception exception = assertThrows(NumberFormatException.class, () -> {
        ttdmainObj.add("//;-1;-2");
      });

      String expectedMessage = "Invalid String Received : [//;-1;-2]";
      String actualMessage = exception.getMessage();
      assertTrue(actualMessage.equals(expectedMessage), "Expected an NumberFormatException to be thrown with custom message");
    }


    @Test
    @DisplayName("Test Add Method handle Invalid Pattern")
    public void testAddMethodHandleNegativeNumberAlongWithPositiveNumber() {
      Exception exception = assertThrows(Exception.class, () -> {
        ttdmainObj.add("//;\n-1;2;3;-4");
      });

      String expectedMessage = "Negatives not allowed : [-1, -4]";
      String actualMessage = exception.getMessage();
      assertTrue(actualMessage.equals(expectedMessage), "Expected an Exception to be thrown with custom message and the numbers");
    }
  }
}
