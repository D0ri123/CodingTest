package baekjoon.priority_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 가운데를 말해요

public class Code05 {

  public static void main(String[] args) throws Exception {
    Comparator<Integer> maxComp = new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    };

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxComp);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int count = 0;

    while(count < n) {
      int input = Integer.parseInt(br.readLine());
      if(maxHeap.size() == minHeap.size()) {
        maxHeap.add(input);
      } else {
        minHeap.add(input);
      }

      if(!maxHeap.isEmpty() && !minHeap.isEmpty() && minHeap.element() < maxHeap.element()) {
        int minElement = minHeap.poll();
        int maxElement = maxHeap.poll();

        maxHeap.add(minElement);
        minHeap.add(maxElement);
      }

      System.out.println(maxHeap.peek());
      count++;
    }

  }
}
