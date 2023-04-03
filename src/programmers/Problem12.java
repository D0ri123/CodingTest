package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//5,5) A=(11,2) B=(10,1
//[100,1],[100,2],[50,1]
//[3, 1], [1, 4], [2, 3], [2, 3], [1, 5], [1, 0], [1, 0]
//{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}

//인사고과
public class Problem12 {
  public static void main(String[] args) {
    Problem12 sol = new Problem12();
    int[][] scores = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}};
    System.out.println(sol.solution(scores));
  }

  public int solution(int[][] scores) {
    Map<int[], Boolean> list = new HashMap<>();
    int[] wanHo = scores[0];
    int wanhoScore = scores[0][0] + scores[0][1];
    int answer = 0;

    //근무 태도점수는 내림차순 정렬하고, 평가 점수는 오름차순 정렬한다.
    Arrays.sort(scores, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o2[0] - o1[0];
      }
    });
    list.put(scores[0], true);

    // 제외되는 사람을 map으로 기록한다.
    for(int i=1; i<scores.length; i++) {
      if(scores[i-1][1] > scores[i][1]) {
        list.put(scores[i], false);
        if(scores[i] == wanHo) return -1;
      } else {
        list.put(scores[i], true);
      }
    }

    // 완호가 인센티브를 받을 수 있다면 석차를 매긴다.
    for(int i=0; i<scores.length; i++) {
      if(list.get(scores[i])) {
        int score = scores[i][0] + scores[i][1];
        if(score > wanhoScore) {
          answer++;
        }
      }
    }
    return answer+1;
  }


}
