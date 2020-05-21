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
    int gcd = EA(x, y);

    System.out.println("Finding inverse modulo b = " + x + "^-1 mod " + y);

    int s = 1;
    int t = 1;

    int n = lines.size() - 1;
    int i = n;
    
    // first line
    int[] line = lines.get(i);
    int[] line2 = lines.get(i-1);
    t = t * -1;
    System.out.println("     Rewriting lines in terms of remainder and substituting in");
    System.out.println("     " + i + ": 1 = (" + s + ")" + line[0] + " + (" + t + ")" + line[1]);

    while (i > 1) {
      line = lines.get(i);
      line2 = lines.get(i-1);
      if (i % 2 == n % 2){
        System.out.println("        1 = (" + s + ")" + line[0] + " + (" + t + ")(" + line2[0] + " + (" + -line2[2] + ")" + line2[1] + ")");

        int fac = -line2[2] * t;
        System.out.println("        1 = (" + s + ")" + line[0] + " + (" + t + ")" + line2[0] + " + (" + fac + ")" + line2[1]);

        s = s + fac;
        System.out.println("     " + (i-1) + ": 1 = (" + s + ")" + line[0] + " + (" + t + ")" + line2[0]);
      } else {
        System.out.println("        1 = (" + s + ")(" + line2[0] + " + (" + -line2[2] + ")" + line2[1] + ") + (" + t + ")" + line[0]);

        int fac = -line2[2] * s;
        System.out.println("        1 = (" + s + ")" + line2[0] + " + (" + fac + ")" + line2[1] + " + (" + t + ")" + line[0]);

        t = t + fac;
        System.out.println("     " + (i-1) + ": 1 = (" + s + ")" + line2[0] + " + (" + t + ")" + line2[1]);
      }
      i--;
    }

    System.out.println("Bézout's coefficients of (" + x + "," + y + ") is (" + s + ", " + t + ")");
    System.out.println(s + "*" + x + " + " + t + "*" + y + " = gcd(" + x + "," + y + ")");
    if(gcd != 1) {
      System.out.println(x + " and " + y + " are not coprime");
      System.out.println("Inverse Modulo: " + x + "^-1 mod " + y + " = undefined");
    } else {
      System.out.println("Inverse Modulo (signed):   " + x + "^-1 mod " + y + " = " + t);
      if(t < 0) t += y;
      System.out.println("Inverse Modulo (positive): " + x + "^-1 mod " + y + " = " + t);
    }
  }

  public static int EA(int a, int b) {
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
    return lines.get(i)[3];
  }



}