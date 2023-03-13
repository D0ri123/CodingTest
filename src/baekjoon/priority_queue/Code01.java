package baekjoon.priority_queue;

import java.util.*;

// 최소 힙
public class Code01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0; i<n; i++) {
      int x = sc.nextInt();
      if(x == 0) {
        System.out.println(solution(pq));
      } else {
        pq.add(x);
      }
    }
  }

  public static int solution(PriorityQueue<Integer> pq) {
    if(pq.isEmpty()) {
      return 0;
    }
    else {
      return pq.poll();
    }
  }

}
