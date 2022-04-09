package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) throws Exception {
    if (number.isEmpty()) {
      return 0;
    }

    String numbers[] = splitStringWithDelimeter(number);

    return getSumOfNumbers(numbers);
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

  private int getIntegerFromString(String text) throws Exception {
    text = text.trim();
    int number = Integer.parseInt(text);

    if(number < 0){
      throw new Exception("Negatives not allowed - "+number);
    }
    return number;
  }

  private int getSumOfNumbers(String[] numbers) throws Exception {
    int sum = 0;
    for (String numberString : numbers) {
      sum += getIntegerFromString(numberString);
    }
    return sum;
  }
}
