package baekjoon.priority_queue;

import java.util.*;

// 카드 정렬하기

public class Code04 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int result = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0; i<n ; i++) {
      int x = sc.nextInt();
      if(n == 1) { // 카드 묶음이 하나라면, 비교할 필요가 없다.
        System.out.println(result);
        return;
      }
      pq.add(x);
    }

    while(pq.size() >= 2) {
      int a = pq.poll();
      int b = pq.poll();
      result += (a + b);
      pq.add(a + b);
    }

    System.out.println(result);

  }

}
