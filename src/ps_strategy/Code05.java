package ps_strategy;

// 좌석번호, 인프런

import java.util.Arrays;

public class Code05 {
  public int[] solution(int c, int r, int k){
    int[][] arr = new int[c][r];
    arr[0][0] = 1;

    int[] answer = {0,0};
    int order = 2;
    int x = 0, y = 0, d = 0;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    if(k > c * r) { //배열에 들어갈 수 있는 최대숫자보다 큰 번호가 들어오면 [0,0]을 반환함
      return answer;
    }

    while(order <= k) {
      int nx = x + dx[d];
      int ny = y + dy[d];
      if(nx < 0 || ny < 0 || nx >= c || ny >= r || arr[nx][ny]!=0) {
        d = (d+1) % 4;
        continue;
      }

      if(order == k) {
        answer[0] = nx+1;
        answer[1] = ny+1;
        break;
      }

      x = nx;
      y = ny;
      arr[x][y] = order++;
    }

    return answer;
  }

  public static void main(String[] args){
    Code05 T = new Code05();
    System.out.println(Arrays.toString(T.solution(6, 5, 12))); //[6,3]
    System.out.println(Arrays.toString(T.solution(6, 5, 20))); //[2,3]
    System.out.println(Arrays.toString(T.solution(6, 5, 30))); //[4,3]
    System.out.println(Arrays.toString(T.solution(6, 5, 31))); //[0,0]
  }
}
