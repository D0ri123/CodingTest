package inflearn.dp;

// 사탕 가게

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Code01 {
  public static ArrayList<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    Code01 pro = new Code01();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean flag = true;

    while(flag) {
      String in = br.readLine();
      String[] input = in.split(" ");

      if(input[0].equals("0") && input[1].equals("0.00")) {
        flag = false;
      }

      int n = Integer.valueOf(input[0]); // 가게에 있는 사탕의 종류 수
      double m = Double.valueOf(input[1]); // 상근이가 가지고 있는 돈의 양

      int[] calories = new int[n];
      int[] price = new int[n];

      for(int i=0; i<n; i++) {
        String tc = br.readLine();
        String[] strings = tc.split(" ");
        calories[i] = Integer.valueOf(strings[0]);
        price[i] = (int) (((Double.valueOf(strings[1]) * 100)) + 0.5); //double 때문에 안됨
      }

      pro.solution(calories, price, m);
    }

    for(int i=0; i<list.size()-1; i++) {
      System.out.println(list.get(i));
    }
  }

  public void solution(int[] calories, int[] price, double m) {
    int num = (int) (m * 100);
    int[] dp = new int[num+1]; //dp[i] = i원을 가지고 얻을 수 있는 최대 칼로리

    //calories.length 가 사탕의 종류와 동일하다.
    for(int i=0; i<calories.length; i++) {
      int unitPrice = price[i];
      for(int j=unitPrice; j<dp.length; j++) {
        dp[j] = Math.max(dp[j], dp[j - unitPrice] + calories[i]);
      }
    }

    list.add(dp[num]);
  }

}
