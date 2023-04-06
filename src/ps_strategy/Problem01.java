package ps_strategy;

// 소풍

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem01 {
  public static boolean[][] network;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int totalCase = Integer.parseInt(br.readLine());
    int idx = 0;
    while(idx < totalCase) {
      String str1 = br.readLine();
      String[] arr = str1.split(" ");
      int n = Integer.parseInt(arr[0]); // 학생의 수
      int m = Integer.parseInt(arr[1]); // 친구 쌍의 수

      network = new boolean[n][n];
      boolean[] isMatched = new boolean[n];

      String str2 = br.readLine();
      String[] friendship = str2.split(" ");
      for(int i=0; i<friendship.length; i=i+2) {
        int friend1 = Integer.parseInt(friendship[i]);
        int friend2 = Integer.parseInt(friendship[i+1]);

        network[friend1][friend2] = true;
        network[friend2][friend1] = true;
      }
      System.out.println(matchingFriends(isMatched));
      idx++;
    }
  }

  public static int matchingFriends(boolean[] isMatched) {
    int firstFree = -1;
    for(int i=0; i<isMatched.length; i++) {
      if(!isMatched[i]) {
        firstFree = i;
        break;
      }
    }
    if(firstFree == -1) return 1;
    int ret = 0;
    for(int pairWith=firstFree + 1; pairWith<isMatched.length; pairWith++) {
      if(!isMatched[pairWith] && network[firstFree][pairWith]) {
        isMatched[pairWith] = isMatched[firstFree] = true;
        ret += matchingFriends(isMatched);
        isMatched[firstFree] = isMatched[pairWith] = false;
      }
    }
    return ret;
  }
}
