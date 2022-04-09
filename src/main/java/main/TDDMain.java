package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else {
      String numbers[] = splitStringWithDelimeter(number);
      int sum = 0;
      for (String numberString : numbers) {
        sum += getIntegerFromString(numberString);
      }
      return sum;
    }
  }

  private String[] splitStringWithDelimeter(String number) {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(number);
    if (matcher.matches()) {

      String delimiter = matcher.group(1);
      String numberString = matcher.group(2);

      return numberString.split(delimiter);
    }

    return number.split(",|\n");
  }

  private int getIntegerFromString(String number) {
    number = number.trim();
    return Integer.parseInt(number);
  }
}
