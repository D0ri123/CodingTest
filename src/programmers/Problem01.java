package programmers;

import java.util.*;

public class Problem01 {
  public static void main(String[] args){
    Problem01 problem01 = new Problem01();
    int[] answer = problem01.solution(2,1); // n은 집합에 있는 자연수의 개수, s는 집합의 모든 원소의 합.
    System.out.println(Arrays.toString(answer));
  }

  /**
   * @param n 집합에 있는 자연수의 개수.
   * @param s 집합에 있는 모든 원소의 합.
   * @return 최고의 집합.
   */
  public int[] solution(int n, int s){
    int[] answer = new int[n];
    int[] errAnswer = {-1};

    if(s<n) return errAnswer;

    if(s%n == 0) {
      Arrays.fill(answer, s/n);
    } else if(s%n == 1) {
      Arrays.fill(answer, s/n);
      answer[n-1] += 1;
    } else if(s%n < n) {
      Arrays.fill(answer, s/n);
      int number = s%n;
      int index = n-1;
      while(number != 0){
        answer[index--] += 1;
        number--;
      }
    }

    return answer;
  }

}
