package programmers;

//광물 캐기

import java.util.ArrayList;
import java.util.Arrays;

public class Problem21 {
  public int minCost = Integer.MAX_VALUE;
  public static void main(String[] args) {
    Problem21 pro = new Problem21();
    int[] picks1 = {1, 3, 2}; //{다이아, 철, 돌} 순으로 저장된다.
    String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
    System.out.println(pro.solution(picks1, minerals1));
//
//    int[] picks2 = {0, 1, 1};
//    String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
//    System.out.println(pro.solution(picks2, minerals2));
  }

  public int solution(int[] picks, String[] minerals) {
    int totalPick = Arrays.stream(picks).sum();
    int mineralUnit = minerals.length/5 + 1;
    int depth = Math.min(totalPick, mineralUnit);

    //repeated는 반복하는 작업수
    dfs(picks, minerals, depth, 1, 0);

    return minCost;
  }

  public void dfs(int[] picks, String[] minerals, int depth, int repeated, int cost) {
    if(depth+1 == repeated) {
      minCost = Math.min(minCost, cost);
    } else{
     for(int i=0; i<picks.length; i++) {
       if(picks[i] != 0) {
         picks[i] -= 1;
         ArrayList<String> arr = new ArrayList<>(5);

         int len = Math.min(minerals.length, 5 * repeated);
         for(int j=5*(repeated-1); j<len; j++) {
           arr.add(minerals[j]);
         }

         dfs(picks, minerals, depth, repeated+1, cost + addCost(i, arr));
         picks[i] += 1;
       }
     }
    }
  }

  private int addCost(int pick, ArrayList<String> minerals) {
    int answer = 0;
    if(pick == 0) { //다이아를 택한 경우
      answer = minerals.size(); //다이아는 어떤 경우에도 1을 더하므로
    } else if(pick == 1) { //철을 택한 경우
      for(String mineral : minerals) {
        if(mineral.equals("diamond")) answer += 5;
        else answer += 1;
      }
    } else if(pick == 2) { //돌을 택한 경우
      for(String mineral : minerals) {
        if(mineral.equals("diamond")) answer += 25;
        else if(mineral.equals("iron")) answer += 5;
        else answer += 1;
      }
    }
    return answer;
  }


}
