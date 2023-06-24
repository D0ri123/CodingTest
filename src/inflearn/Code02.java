package ps_strategy;

import java.util.Arrays;

//청소, 인프런
public class Code02 {

  // 상(위)부터 시계방향대로 움직인다.
  public int dx[] = {-1,0,1,0};
  public int dy[] = {0,1,0,-1};

  public static void main(String[] args){
    Code02 T = new Code02();
//    int[][] arr1 =
//        {{0, 0, 0, 0, 0},
//         {0, 1, 1, 0, 0},
//         {0, 0, 0, 0, 0},
//         {1, 0, 1, 0, 1},
//         {0, 0, 0, 0, 0}};
//    System.out.println(Arrays.toString(T.solution(arr1, 10)));

//    int[][] arr2 =
//        {{0, 0, 0, 1, 0, 1},
//         {0, 0, 0, 0, 0, 0},
//         {0, 0, 0, 0, 0, 1},
//         {1, 1, 0, 0, 1, 0},
//         {0, 0, 0, 0, 0, 0},
//         {0, 0, 0, 0, 0, 0}};
//    System.out.println(Arrays.toString(T.solution(arr2, 20)));

    int[][] arr3 =
        {{0, 0, 1, 0, 0},
         {0, 1, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {1, 0, 0, 0, 1},
         {0, 0, 0, 0, 0}};
    System.out.println(Arrays.toString(T.solution(arr3, 25)));

  }

  public int[] solution(int[][] arr, int k) {
    int t = 0;
    int d = 1;
    int x = 0, y = 0;

    while(t < k) {
      int nx = x + dx[d];
      int ny = y + dy[d];
      if(nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length || arr[nx][ny] == 1) {
        d = (d+1) % 4;
        t++;
        continue;
      }
      x = nx;
      y = ny;
      t++;
    }

    return new int[]{x,y};

  }
}
