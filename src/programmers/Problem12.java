package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//5,5) A=(11,2) B=(10,1
//[100,1],[100,2],[50,1]
//[3, 1], [1, 4], [2, 3], [2, 3], [1, 5], [1, 0], [1, 0]
//{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}
class Score {
  int attitude;
  int rating;
  boolean notExcepted;
  public Score(int attitude, int rating, boolean notExcepted) {
    this.attitude = attitude;
    this.rating = rating;
    this.notExcepted = notExcepted;
  }
}


//인사고과
public class Problem12 {
  public static void main(String[] args) {
    Problem12 sol = new Problem12();
    int[][] scores = {{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}};
    System.out.println(sol.solution(scores));
  }

  public int solution(int[][] scores) {
    ArrayList<Score> list = new ArrayList<>();
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
    list.add(new Score(scores[0][0], scores[0][1], true));

    // 제외되는 사람을 map으로 기록한다.
    for(int i=1; i<scores.length; i++) {
      if(scores[i-1][1] > scores[i][1]) {
        list.add(new Score(scores[i][0], scores[i][1], false));
        if(scores[i] == wanHo) return -1;
      } else {
        list.add(new Score(scores[i][0], scores[i][1], true));
      }
    }

    // 완호가 인센티브를 받을 수 있다면 석차를 매긴다.
    for(int i=0; i<scores.length; i++) {
      Score s = list.get(i);
      if(s.notExcepted) {
        int score = s.attitude + s.rating;
        if(score > wanhoScore) {
          answer++;
        }
      }
    }
    return answer+1;
  }


}
