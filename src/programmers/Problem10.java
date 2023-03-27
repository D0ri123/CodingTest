package programmers;

import java.util.Arrays;

// 도둑질
public class Problem10 {
  public static void main(String[] args) {
    int[] money = {1,2,3,1};
    Problem10 sol = new Problem10();
    System.out.println(sol.solution(money));
  }

  public int solution(int[] money) {
    int answer = 0;
    int len = money.length;

    if(len==3) {
      return Arrays.stream(money).max().getAsInt();
    }

    int[] noFirst = divide(0, new int[money.length], money); //처음을 추가 안함
    int[] noEnd = divide(len-1, new int[money.length], money); //끝을 추가 안함

    for(int i=2; i<money.length; i++) {
      noFirst[i] = Math.max(noFirst[i-1], noFirst[i-2] + noFirst[i]);
      noEnd[i] = Math.max(noEnd[i-1], noEnd[i-2] + noEnd[i]);
      answer = Math.max(answer, Math.max(noFirst[i], noEnd[i]));
    }

    return answer;
  }

  public int[] divide(int index, int[] newMoney, int[] money) {
    for(int i=0; i<money.length; i++) {
      if(i != index) newMoney[i] = money[i];
      else newMoney[i] = 0;
    }
    return newMoney;
  }

}
