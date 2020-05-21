import java.util.ArrayList;
import java.util.Scanner;

/*
* Inverse Modulo
* a * x ≡ 1 (mod b), given a and b find x
* An Inverse modulo can be found using the Extended Euclidian Algorithm (EEA).
*/

public class EEA {
  public static void main(String[] args) {
    System.out.println("Enter two integers seperated by a space");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.close();
    
    EAA_small(a, b);
    // EAA_table(a, b);
  }

  /*
  * https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Pseudocode
  */
  public static void EAA_small(int a, int b) {
    int s = 0;
    int t = 1;
    int r = b;
    int old_s = 1;
    int old_t = 0;
    int old_r = a;

    while (r != 0) {
      int q = old_r / r;

      int temp = r;
      r = old_r - q * temp;
      old_r = temp;

      temp = s;
      s = old_s - q * temp;
      old_s = temp;

      temp = t;
      t = old_t - q * temp;
      old_t = temp;      
    }

    System.out.println("Bézout coefficients: (" + old_s + ", " + old_t + ")");
    System.out.println("Greatest common divisor: " + old_r);
    if(old_r != 1) {
      System.out.println(a + " and " + b + " are not coprime");
      System.out.println("Inverse Modulo: " + a + "^-1 mod " + b + " = undefined");
    } else {
      System.out.println("Inverse Modulo (signed):   " + a + "^-1 mod " + b + " = " + old_s);
      if(old_s < 0) old_s += b;
      System.out.println("Inverse Modulo (positive): " + a + "^-1 mod " + b + " = " + old_s);
    }
  }

  /*
  * https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm#Example
  */
  public static void EAA_table(int a, int b) {
    ArrayList<int[]> EEA = new ArrayList<int[]>();
    EEA.add(0, new int[] { 0, a, 1, 0 });
    EEA.add(1, new int[] { 0, b, 0, 1 });
    int gcd, b1, b2, q, r = 1, s = 1, t = 1;
    int j = 2;
    while (true) {
      int[] line2 = EEA.get(j - 2);
      int[] line1 = EEA.get(j - 1);

      q = (int) Math.floor(line2[1] / line1[1]);
      int prevR = r;
      r = line2[1] % line1[1];
      if (r <= 0) {
        gcd = prevR;
        b1 = s;
        b2 = t;
        break;
      }
      s = line2[2] - q * line1[2];
      t = line2[3] - q * line1[3];
      EEA.add(j, new int[] { q, r, s, t });
      System.out.println("q " + EEA.get(j)[0] + " r " + EEA.get(j)[1] + " s " + EEA.get(j)[2] + " t " + EEA.get(j)[3]);
      j++;
    }
    System.out.println("Bézout's coefficients of (" + a + "," + b + ") -> (" + b1 + ", " + b2 + ")");
    System.out.println("gcd(" + a + "," + b + ") = " + gcd);
    if(gcd != 1) {
      System.out.println(a + " and " + b + " are not coprime");
      System.out.println("Inverse Modulo: " + a + "^-1 mod " + b + " = undefined");
    } else {
      System.out.println("Inverse Modulo (signed):   " + a + "^-1 mod " + b + " = " + b1);
      if(b1 < 0) b1 += b;
      System.out.println("Inverse Modulo (positive): " + a + "^-1 mod " + b + " = " + b1);
    }
  }
}