package ps_strategy;

import java.util.Arrays;

// 사다리 타기, 인프런

public class Code01 {
  public static void main(String[] args) {
    Code01 T = new Code01();
    System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
    System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
    System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
    System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
  }

  /**
   * n은 학생수, arrays는 가로막대 정보
   */
  public static char[] solution(int n, int[][] arrays) {
    int[] answer = new int[n];
    initSet(answer);

    int idx = 0;
    while(idx<n) {
      for (int[] info : arrays) {
        for (int start : info) {
          if (answer[idx] == start)
            answer[idx] = start + 1;
          else if (answer[idx] == start + 1)
            answer[idx] = start;
        }
      }
      idx++;
    }

    return changeOrderToName(answer);
  }

  private static void initSet(int[] students) {
    for(int i=0; i<students.length; i++) {
      students[i] = i+1;
    }
  }

  private static char[] changeOrderToName(int[] answer) {
    char name = 'A';
    char[] result = new char[answer.length];
    for(int idx : answer) {
      result[idx-1] = name++;
    }
    return result;
  }

}
