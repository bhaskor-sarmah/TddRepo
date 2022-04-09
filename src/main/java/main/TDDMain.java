package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else {
      String numbers[] = splitStringWithDelimeter(number);
      int sum = 0;
      for(String numberString : numbers){
        sum += getIntegerFromString(numberString);
      }
      return sum;
    }
  }

  private String[] splitStringWithDelimeter(String number) {
    return number.split(",|\n");
  }

  private int getIntegerFromString(String number){
    number = number.trim();
    return Integer.parseInt(number);
  }
}
