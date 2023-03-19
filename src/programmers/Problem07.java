package programmers;

//비밀 지도

import java.util.Arrays;

public class Problem07 {
  public static void main(String[] args) {
    int n = 6;
    int[] arr1 = {46, 33, 33 ,22, 31, 50};
    int[] arr2 = {27 ,56, 19, 14, 14, 10};
    Problem07 sol = new Problem07();
    System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
  }

  public String[] solution(int n, int[] arr1, int[] arr2) {
    int idx = 0;
    String[] map = new String[n];
    while(idx < n) {
      String result = Integer.toBinaryString(arr1[idx] | arr2[idx]);
      if(result.length()!=n) {
        int cnt = n - result.length();
        result = "0".repeat(cnt) + result;
      }
      map[idx] = parsing(result, idx++);
    }
    return map;
  }

  public static String parsing(String result, int idx) {
    StringBuilder sb = new StringBuilder();
    String[] spell = result.split("");
    for(String str : spell) {
      if(str.equals("1")) sb.append("#");
      else sb.append(" ");
    }
    return sb.toString();
  }

}
