package baekjoon.dp;

// 01타일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code03 {
  public static long[] arr = new long[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;

    for(int i=3; i<arr.length; i++) {
      arr[i] = -1;
    }

    System.out.println(dp(n));

  }

  public static long dp(int n) {
    if(arr[n] == -1) {
      arr[n] = (dp(n-1) + dp(n-2)) % 15746;
    }
    return arr[n];
  }

}
