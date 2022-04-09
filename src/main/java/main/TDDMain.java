package main;

public class TDDMain {
  public static void main(String[] args) {

  }

  public int add(String number){
    if(number.equals("")){
      return 0;
    }
    int num  = Integer.parseInt(number);
    return num;
  }
}
