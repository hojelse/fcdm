import java.util.Scanner;

/**
 * BaseConversion
 */
public class BaseConversion {

  public static void main(String[] args) {
    System.out.println("Enter two integers seperated by a space ex.: 17 43");

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int b = sc.nextInt();
    sc.close();

    System.out.println(covert(n, b));
  }

  private static String covert(int n, int b) {
    
    return null;
  }
}