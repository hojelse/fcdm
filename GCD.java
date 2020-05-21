import java.util.ArrayList;
import java.util.Scanner;

/*
* Greatest Common Divisor
* The greatest common divisor between two numbers a and b can be found by using the Euclidian Algorithm (EA).
*/

public class GCD {

  public static void main(String[] args) {
    System.out.println("Enter two integers seperated by a space ex.: 17 43");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.close();

    EA(a, b);
  }

  public static void EA(int a, int b) {
    System.out.println();
    System.out.println("Calculating gcd(" + a + "," + b + ") ...");
    System.out.println("     Format: Divident = Divisor * Quotient + Remainder");

    ArrayList<int[]> lines = new ArrayList<int[]>();
    int A = a;
    int B = b;
    int Q, R;

    Q = (int) A / B;
    R = A % B;
    lines.add(new int[] { A, B, Q, R });

    int[] line = lines.get(0);
    System.out.println("     0: " + line[0] + " = " + line[1] + " * " + line[2] + " + " + line[3]);

    int i = 0;
    while (R > 0) {
      int[] lastLine = lines.get(i);

      A = lastLine[1];  // A = Dividend 
      B = lastLine[3];  // B = Divisor  
      Q = (int) A / B;  // Q = Quotient 
      R = A % B;        // R = Remainder

      lines.add(new int[] { A, B, Q, R });
      i++;
      line = lines.get(i);
      System.out.println("     " + i + ": " + line[0] + " = " + line[1] + " * " + line[2] + " + " + line[3]);

    }

    System.out.println("gcd(" + a + "," + b + ") = " + lines.get(i)[1]);
  }

}