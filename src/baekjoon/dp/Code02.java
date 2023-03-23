package baekjoon.dp;

// 피보나치 수 2

import java.util.Scanner;

public class Code02 {
  public static long[] fibo;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    fibo = new long[n+1];
    fibo[0] = 0;
    fibo[1] = 1;

    for(int i=2; i<=n; i++) {
      fibo[i] = fibo[i-1] + fibo[i-2];
    }

    System.out.println(fibo[n]);
  }
}
