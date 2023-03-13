package baekjoon.priority_queue;

// 절댓값 힙

import java.util.*;

public class Code03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Comparator<Integer> customComp = new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if(Math.abs(o1) == Math.abs(o2)) {
          return o1 - o2;
        }
        return Math.abs(o1) - Math.abs(o2);
      }
    };

    PriorityQueue<Integer> pq = new PriorityQueue<>(customComp);

    int n = sc.nextInt();
    for(int i=0; i<n ; i++) {
      int x = sc.nextInt();
      if(x == 0) {
        System.out.println(solution(pq));
      }
      else {
        pq.add(x);
      }
    }
  }

  public static int solution(PriorityQueue<Integer> pq) {
    if(pq.isEmpty()) {
      return 0;
    }
    return pq.poll();
  }

}
