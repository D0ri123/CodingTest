package programmers;

// 우박수열 정적분
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Problem15 {
  public HashMap<Integer, Integer> map = new HashMap<>();
  public static void main(String[] args) {
    Problem15 sol = new Problem15();
    int k = 5;
    int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
    System.out.println(Arrays.toString(sol.solution(k, ranges)));


  }

  public double[] solution(int k, int[][] ranges) {
    double[] result = new double[ranges.length];
    double[] areaSum = new double[201];
    applyCollatz(k, areaSum);

    int lastCoordinate = map.size()-1;
    for(int i=0; i<ranges.length; i++) {
      int start = ranges[i][0];
      int end = lastCoordinate + ranges[i][1];
      if(start > end) {
        result[i] = -1.0;
      } else if(start == end) {
        result[i] = 0.0;
      } else {
        result[i] = areaSum[end] - areaSum[start];
      }
    }
    return result;
  }

  private Map<Integer, Integer> applyCollatz(int k, double[] areaSum) {
    int level = 0;
    double sum = 0;

    areaSum[level] = sum;
    map.put(level++, k);

    while(k > 1) {
      if(k%2 == 0) {
        k /= 2;
        map.put(level, k);
      } else {
        k = (3*k) + 1;
        map.put(level, k);
      }
      sum += calculateArea((double)map.get(level-1), k);
      areaSum[level] = sum;
      level++;
    }
    return map;
  }

  private double calculateArea(double upLen, double downLen) {
    return (upLen + downLen)/2;
  }

}
