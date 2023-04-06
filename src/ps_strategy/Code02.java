package ps_strategy;

import java.util.Arrays;

//청소, 인프런

class Cleaner {
  int direction;
  int xPos;
  int yPos;

  public void setDirection(int dir) {
    this.direction = dir;
  }

  public void setX(int x) {
    this.xPos = x;
  }

  public void setY(int y) {
    this.yPos = y;
  }

  public Cleaner(int dir, int x, int y) {
    this.direction = dir;
    this.xPos = x;
    this.yPos = y;
  }

  public int perform(int[][] arr, int time) {

    int presentDir = this.direction;
    int present = 0;

    switch (presentDir) {
      case 1: //처음 위치 1은 무조건 '우'여야 한다.
        for(int i=this.yPos; i<arr[this.xPos].length; i++) {
          if(arr[this.xPos][i] == 1) {
            this.setDirection(presentDir+1);
            time++;
            this.setY(i);
            return time;
          }
          time++; //위치 주의깊게 볼 것.
          present = i;
        }
        this.setDirection(this.direction+1);
        this.setY(present);
        time++;
        break;
      case 2: //1 다음의 위치는 '하'여야 한다.
        for(int i=this.xPos; i<arr.length; i++) {
          if(arr[i][this.yPos] == 1) {
            this.setDirection(presentDir + 1);
            this.setX(i);
            time++;
            return time;
          }
          time++;
          present = i;
        }
        this.setDirection(this.direction+1);
        this.setX(present);
        time++;
        break;
      case 3: // 2 다음의 위치는 '좌'여야 한다.
        for(int i=this.yPos; i>=0; i--) {
          if(arr[this.xPos][i] == 1) {
            this.setDirection(presentDir+1);
            this.setY(i);
            time++;
            return time;
          }
          time++;
          present = i;
        }
        this.setDirection(this.direction+1);
        this.setY(present);
        time++;
        break;
      case 4: // 3 다음의 위치는 '상'이어야 한다.
        for(int i=this.xPos; i>=0; i--) {
          if(arr[i][this.yPos] == 1) {
            this.setDirection(presentDir + 1);
            this.setX(i);
            time++;
            return time;
          }
          time++;
          present = i;
        }
        this.setDirection(this.direction+1);
        this.setX(present);
        time++;
        break;
    }
    return time;
  }
}

public class Code02 {
  public static void main(String[] args){
    Code02 T = new Code02();
    int[][] arr1 =
        {{0, 0, 0, 0, 0},
         {0, 1, 1, 0, 0},
         {0, 0, 0, 0, 0},
         {1, 0, 1, 0, 1},
         {0, 0, 0, 0, 0}};
    System.out.println(Arrays.toString(T.solution(arr1, 10)));
//    int[][] arr2 =
//        {{0, 0, 0, 1, 0, 1},
//         {0, 0, 0, 0, 0, 0},
//         {0, 0, 0, 0, 0, 1},
//         {1, 1, 0, 0, 1, 0},
//         {0, 0, 0, 0, 0, 0},
//         {0, 0, 0, 0, 0, 0}};
//    System.out.println(Arrays.toString(T.solution(arr2, 20)));
//    int[][] arr3 =
//        {{0, 0, 1, 0, 0},
//         {0, 1, 0, 0, 0},
//         {0, 0, 0, 0, 0},
//         {1, 0, 0, 0, 1},
//         {0, 0, 0, 0, 0}};
//    System.out.println(Arrays.toString(T.solution(arr3, 25)));

  }

  public int[] solution(int[][] arr, int n) {
    Cleaner robot = new Cleaner(1,0,0);
    int time = 0;
    while(time < n) {
      time = robot.perform(arr, time);
    }

    return new int[]{robot.xPos, robot.yPos};
  }



}
