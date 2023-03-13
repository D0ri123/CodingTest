package baekjoon.priority_queue;

// 최대 힙

import java.util.*;

// 최대 힙

public class Code02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Comparator<Integer> maxComp = new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    };

    PriorityQueue<Integer> pq = new PriorityQueue<>(maxComp);
    for(int i=0; i<n; i++) {
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
