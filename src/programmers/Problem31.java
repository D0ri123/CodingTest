package programmers;

//다단계 칫솔 판매

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 1. 자신을 key로, 부모를 value로 하는 map 을 생성
 * 2.
 */
public class Problem31 {
  public static Map<String, String> info = new HashMap<>();
  public static Map<String, Integer> idx = new HashMap<>();
  public static void main(String[] args) {
    Problem31 pro = new Problem31();

    String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    String[] seller = {"young", "john", "tod", "emily", "mary"};
    int[] amount = {12, 4, 2, 5, 10};
    //[360, 957, 108, 0, 450, 18, 180, 1080] -> 오답
    //[360, 958, 108, 0, 450, 18, 180, 1080] -> 정답

    System.out.println(Arrays.toString(pro.solution(enroll, referral, seller, amount)));
  }

  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = new int[enroll.length];

    for(int i=0; i<enroll.length; i++) {
      info.put(enroll[i], referral[i]); //직원과 직원의 추천인 정보를 넣는다.
      idx.put(enroll[i], i); //직원과 직원의 순서 정보를 넣는다.
    }

    for(int i=0; i<seller.length; i++) {
      double profit = amount[i] * 100; //실제 판매 가격
      answer[idx.get(seller[i])] += (int)(profit * 0.9);
      dfs((int)(profit * 0.1), info.get(seller[i]), answer);
    }

    return answer;
  }

  public void dfs(double profit, String seller, int[] answer) {
    if (!seller.equals("-")) {
      if (profit * 0.1 < 1) {
        answer[idx.get(seller)] += (int)profit;
        return;
      }
      answer[idx.get(seller)] += Math.ceil(profit * 0.9);
      dfs(profit * 0.1, info.get(seller), answer);
    }
  }
}
