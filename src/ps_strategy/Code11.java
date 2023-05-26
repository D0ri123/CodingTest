package ps_strategy;

//최대 인원수

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Code11 {
  public static void main(String[] args) {
    Code11 pro = new Code11();

    int n = 5;
    int[][] trains = {{1, 4, 2},{2, 5, 1}};
    int[][] bookings = {{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}};

//    int n = 5;
//    int[][] trains = {{2, 3, 1},{1, 5, 1}};
//    int[][] bookings = {{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}};
//
//    int n = 8;
//    int[][] trains = {{1, 8, 3},{3, 8, 1}};
//    int[][] bookings = {{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}};
//
//    int n = 9;
//    int[][] trains = {{1, 8, 3},{3, 9, 2},{1, 5, 3}};
//    int[][] bookings = {{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}};
//
//    int n = 9;
//    int[][] trains = {{2, 7, 2}, {3, 9, 2}, {1, 5, 3}};
//    int[][] bookings = {{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}};

    System.out.println(pro.solution(n, trains, bookings));

  }

  public int solution(int n, int[][] trains, int[][] bookings) {
    int answer = 0;

    //모든 기차에 대해 수용할 수 있는 인원 정보
    int[] runningCapacity = new int[n+1];

    for(int[] train : trains) {
      runningCapacity[train[0]] += train[2];
      runningCapacity[train[1]] -= train[2];
    }

    //모든 기차가 수용할 수 있는 최대 인원
    for(int j=1; j<=n; j++) {
      runningCapacity[j] += runningCapacity[j-1]; //{0,2,3,3,1,0}
    }

    int bookingLen = bookings.length;
    Arrays.sort(bookings, (a,b) -> a[0] - b[0]);
    LinkedList<Integer> nums = new LinkedList<>();
    int ix = 0;

    for(int i=1; i<=n; i++) {
      while(!nums.isEmpty() && nums.peek() == i) {
        answer++;
        nums.pollFirst();
      }

      while(ix<bookingLen && bookings[ix][0]==i) {
        nums.add(bookings[ix][1]);
        ix++;
      }
      Collections.sort(nums);

      while(nums.size() > runningCapacity[i]) {
        nums.pollLast();
      }
    }

    return answer;
  }
}
