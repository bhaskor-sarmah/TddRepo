package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number) {
    if (number.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(number);
    }
  }
}
