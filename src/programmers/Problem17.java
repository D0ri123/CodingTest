package programmers;

//최소 직사각형

public class Problem17 {
  public static void main(String[] args) {
    int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//    int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
//    int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

    Problem17 pro = new Problem17();
    System.out.println(pro.solution(sizes));
  }

  public int solution(int[][] sizes) {
    int maxW = Integer.MIN_VALUE;
    int maxH = Integer.MIN_VALUE;

    for(int i=0; i<sizes.length; i++) {
      maxH = Math.max(maxH, Math.min(sizes[i][0], sizes[i][1]));
      maxW = Math.max(maxW, Math.max(sizes[i][0], sizes[i][1]));
    }

    return maxW * maxH;
  }
}
