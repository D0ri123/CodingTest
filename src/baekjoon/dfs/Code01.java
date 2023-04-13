package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code01 {
  public static int totalSum = 0;
  public static boolean[] visited;
  public static boolean flag = true;
  public static void main(String[] args) throws IOException {
    Code01 pro = new Code01();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    visited = new boolean[n];

    int index=0;
    String str = br.readLine();

    for(String strNum : str.split(" ")) {
      int num = Integer.parseInt(strNum);
      arr[index++] = num;
      totalSum += num;
    }



    if(totalSum % 2 != 0) {
      System.out.println("NO");
    } else {
      pro.dfs(0,arr);
    }
  }

  public void dfs(int sum, int[] arr) {
    if (!flag)
      return;
    if(sum > totalSum/2) {
      return;
    }
    if (sum == totalSum / 2) {
      System.out.println("YES");
      flag = false;
    } else {
      for (int i = 0; i < arr.length; i++) {
        if (!visited[i]) {
          visited[i] = true;
          sum += arr[i];
          dfs(sum, arr);
          visited[i] = false;
          sum -= arr[i];
        }
      }
    }
  }
}
