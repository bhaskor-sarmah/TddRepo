package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else {
      String numbers[] = number.split(",");
      int sum = 0;
      for(String numberString : numbers){
        sum += getIntegerFromString(numberString);
      }
      return sum;
    }
  }

  private int getIntegerFromString(String number){
    number = number.trim();
    return Integer.parseInt(number);
  }
}
