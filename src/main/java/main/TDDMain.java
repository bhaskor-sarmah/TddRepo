package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else if (number.contains(",")) {
      String numbers[] = number.split(",");
      return getIntegerFromString(numbers[0]) + getIntegerFromString(numbers[1]);
    } else {
      return getIntegerFromString(number);
    }
  }

  private int getIntegerFromString(String number){
    number = number.trim();
    return Integer.parseInt(number);
  }
}
