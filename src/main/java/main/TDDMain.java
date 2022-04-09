package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else if (number.contains(",")) {
      String numbers[] = number.split(",");
      return Integer.parseInt(numbers[0].trim()) + Integer.parseInt(numbers[1].trim());
    } else {
      return Integer.parseInt(number);
    }
  }
}
