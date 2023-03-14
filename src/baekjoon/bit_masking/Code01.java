package baekjoon.bit_masking;

// 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code01 {
  public static StringBuilder sb = new StringBuilder();
  public static int bitSet = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i=0; i<n; i++) {
      String input = br.readLine();
      String[] str = input.split(" ");

      String action = str[0];
      if(action.equals("all") || action.equals("empty")) {
        allOrEmpty(action);
      } else {
        int num = Integer.parseInt(str[1]);
        bitMask(action, num);
      }
    }
    System.out.println(sb);
  }

  public static void bitMask(String action, int num) {
    switch(action) {
      case "add":
        bitSet |= (1<<num);
        break;
      case "remove":
        bitSet &= ~(1<<num);
        break;
      case "check":
        if (((bitSet & (1 << num)) == (1 << num))) {
          sb.append("1\n");
        } else {
          sb.append("0\n");
        }
        break;
      case "toggle":
        bitSet ^= (1 << num);
        break;
    }
  }

  /**
   * n을 입력받은 그대로 1번부터 센다면 (1 << 21) - 1 로 all 해야하고
   * n-1을 사용해 0번부터 센다면 (1 << 20) - 1 로 all 할 수 있음.
   */
  public static void allOrEmpty(String action) {
    if(action.equals("all")) {
      bitSet = (1 << 21) - 1;
    } else {
      bitSet = 0;
    }
  }
}
