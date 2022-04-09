package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else if (number.contains(",")) {
      String numbers[] = number.split(",");
      int sum = 0;
      for(String numberString : numbers){
        sum += getIntegerFromString(numberString);
      }
      return sum;
    } else {
      return getIntegerFromString(number);
    }
  }

  private int getIntegerFromString(String number){
    number = number.trim();
    return Integer.parseInt(number);
  }
}
