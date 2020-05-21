import java.util.ArrayList;
import java.util.Scanner;

/*
* Inverse Modulo / Modular Multiplicative Inverse
* a * x ≡ 1 (mod b), given a and b find x
* ax + by = gcd(a,b)
* An Inverse modulo can be found using the Extended Euclidian Algorithm (EEA).
*/

public class InverseModulo {
  
  static ArrayList<int[]> lines = new ArrayList<>();
  static ArrayList<Integer> r = new ArrayList<>();
  static ArrayList<Integer> q = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("Enter two integers seperated by a space");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.close();

    EAA(a, b);
  }

  public static void EAA(int x, int y) {
    EA(x, y);
    System.out.println();

    if(lines.get(lines.size() - 1)[3] != 1){
      System.out.println("gcd != 0");
    }

    int a = 1;
    int b = 1;

    int n = lines.size() - 1;
    int i = n;
    sub();
    System.out.println(r.get(n));
  }

  public static void sub() {

  }

  public static void EA(int a, int b) {
    System.out.println();
    System.out.println("Calculating gcd(" + a + "," + b + ") ...");
    System.out.println("     Format: Divident = Divisor * Quotient + Remainder");

    int A = a;
    int B = b;
    int Q, R;

    Q = (int) A / B;
    R = A % B;
    lines.add(new int[] { A, B, Q, R });
    q.add(Q);
    r.add(R);

    int[] line = lines.get(0);
    System.out.println("     0: " + line[0] + " = " + line[1] + " * " + line[2] + " + " + line[3]);

    int i = 0;
    while (R > 1) {
      int[] lastLine = lines.get(i);

      A = lastLine[1];  // A = Dividend 
      B = lastLine[3];  // B = Divisor  
      Q = (int) A / B;  // Q = Quotient 
      R = A % B;        // R = Remainder

      lines.add(new int[] { A, B, Q, R });
      q.add(Q);
      r.add(R);
      i++;
      line = lines.get(i);
      System.out.println("     " + i + ": " + line[0] + " = " + line[1] + " * " + line[2] + " + " + line[3]);

    }

    System.out.println("gcd(" + a + "," + b + ") = " + lines.get(i)[3]);
  }



}