package programmers;

// 요격 시스템

import java.util.Arrays;
import java.util.Comparator;

public class Problem24 {
  public static void main(String[] args) {
    Problem24 pro = new Problem24();
    int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
    System.out.println(pro.solution(targets));
  }

  public int solution(int[][] targets) {
    int answer = 1;
    Arrays.sort(targets, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1])
          return o1[0] - o2[0];
        return o1[1] - o2[1];
      }
    });

    int idx = 1;
    int shootingPoint = targets[0][1];

    while(idx < targets.length) {
      if(shootingPoint <= targets[idx][0]) {
        shootingPoint = targets[idx][1];
        answer++;
      }
      idx++;
    }

    return answer;
  }
}
