package ps_strategy;

// 변화하는 중간값 - 우선순위 큐

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem23 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt(); // 테케 수

    for(int i=0; i<c; i++) {
      int n = sc.nextInt(); // 수열의 길이
      int a = sc.nextInt(); // 수열을 생성하는 데 필요한 정수1 (a)
      int b = sc.nextInt(); // 수열을 생성하는 데 필요한 정수2 (b)
      System.out.println(getMedian(n, a, b));
    }
  }

  public static Long getMedian(int n, int a, int b) {
    Comparator<Long> maxComp = new Comparator<>() { // 최대힙 구현하는 comparator.
      @Override
      public int compare(Long o1, Long o2) {
        return (int) (o2 - o1);
      }
    };

    Comparator<Long> minComp = new Comparator<>() { // 최소힙 구현하는 comparator.
      @Override
      public int compare(Long o1, Long o2) {
        return (int) (o1 - o2);
      }
    };

    PriorityQueue<Long> maxHeap = new PriorityQueue<>(maxComp);
    PriorityQueue<Long> minHeap = new PriorityQueue<>(minComp);

    long seed = 1983;
    Long result = 0l;

    for(int i=0; i<n; i++) {
      if(maxHeap.size() == minHeap.size()) {
        maxHeap.add(seed);
      } else {
        minHeap.add(seed);
      }

      if(!maxHeap.isEmpty() && !minHeap.isEmpty() && minHeap.element() < maxHeap.element()) {
        Long minElement = minHeap.poll();
        Long maxElement = maxHeap.poll();

        maxHeap.add(minElement);
        minHeap.add(maxElement);
      }

      seed = (seed * (long) a + b) % 20090711;
      result = (result + maxHeap.element()) % 20090711;
    }
    return result;
  }

}
