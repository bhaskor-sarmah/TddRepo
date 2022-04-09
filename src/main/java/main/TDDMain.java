package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

  private int getIntegerFromString(String number) {
    number = number.trim();
    return Integer.parseInt(number);
  }

  private int getSumOfNumbers(String[] numbers) throws Exception {
    int sum = 0;
    List<Integer> negativeNumbersList = new ArrayList<>();
    for (String numberString : numbers) {
      int number = getIntegerFromString(numberString);
      if(number < 0){
        negativeNumbersList.add(number);
        continue;
      }
      sum += number;
    }

    if(!negativeNumbersList.isEmpty()){
      throw new Exception("Negatives not allowed : "+ Arrays.toString(negativeNumbersList.toArray()));
    }

    return sum;
  }
}
