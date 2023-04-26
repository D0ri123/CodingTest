package ps_strategy;

//잃어버린 강아지
class Thing {
  int x; //x 좌표
  int y; //y 좌표
  int d; //바라보는 위치
  public Thing(int x, int y, int d) {
    this.x = x;
    this.y = y;
    this.d = d;
  }
}

public class Code04 {
  public int solution(int[][] board){
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    Thing person = null;
    Thing dog = null;
    int time = 0;

    //사람과 강아지의 위치 좌표를 찾는다.
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[i].length; j++) {
        if(board[i][j] == 2) {
          person = new Thing(i, j, 0);
        }
        if(board[i][j] == 3) {
          dog = new Thing(i, j, 0);
        }
      }
    }

    if(person == null || dog == null) { // 2 혹은 3이 존재하지 않는 경우
      return 0;
    }

    while(time < 10000) {
      time++;
      int px = person.x + dx[person.d];
      int py = person.y + dy[person.d];
      int dogX = dog.x + dx[dog.d];
      int dogY = dog.y + dy[dog.d];
      boolean flagP = true;
      boolean flagD = true;

      if(!isValidXY(px, py, board)) {
        person.d = (person.d + 1) % 4;
        flagP = false;
      }

      if(!isValidXY(dogX, dogY, board)) {
        dog.d = (dog.d + 1) % 4;
        flagD = false;
      }

      if(flagP) {
        person.x = px;
        person.y = py;
      }

      if(flagD) {
        dog.x = dogX;
        dog.y = dogY;
      }

      if(person.x == dog.x && person.y == dog.y) {
        return time;
      }
    }
    return 0;
  }

  private boolean isValidXY(int x, int y, int[][] board) {
    return x >= 0 && y >= 0 && x < board.length && y < board.length && board[x][y] != 1;
  }
  public static void main(String[] args){
    Code04 T = new Code04();
    int[][] arr1 = {
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
    };
    System.out.println(T.solution(arr1));

    int[][] arr2 = {
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}
    };
    System.out.println(T.solution(arr2));
  }
}
