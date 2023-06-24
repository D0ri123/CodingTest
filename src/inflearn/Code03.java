package ps_strategy;

// 게임 맵 최단거리, BFS

public class Code03 {
  public static int[] dx = {-1,0,1,0};
  public static int[] dy = {0,-1,0,1};
  public static boolean[][] visited = new boolean[5][5];
  public static int count = 0;

  /**
   * 나는 (0,0)에 있고, 적의 진영은 (4,4)에 있다.
   * 0은 벽이 있는 자리를 나타내고, 1은 벽이 없는 자리를 나타낸다.
   */
  public static void main(String[] args) {
    Code03 pro = new Code03();
    int[][] maps = {
        {1,0,1,1,1},
        {1,0,1,0,1},
        {1,0,1,1,1},
        {1,1,1,0,1},
        {0,0,0,0,1}};
//    int[][] maps = {
//        {1,0,1,1,1},
//        {1,0,1,0,1},
//        {1,0,1,1,1},
//        {1,1,1,0,0},
//        {0,0,0,0,1}
//    };
    System.out.println(pro.solution(maps));
  }

  //dfs는 재귀호출을 통해서 해결하는 방식이다.
  public int solution(int[][] maps) {
    int answer = 0;
    dfs(maps, 0, 0);
    return answer;
  }

  public static void dfs(int[][] maps, int x, int y) {
    if(x == maps.length-1 && y == maps.length-1) {

    }
    for(int i=0; i<4; i++) { // for문 내부동작은 상하좌우로 움직이면서, count를 세는 것이다.
      int xPos = x + dx[i];
      int yPos = y + dy[i];
      if(xPos<0 || xPos>=maps.length || yPos<0 || yPos>=maps.length) {
        continue;
      }
      if(maps[xPos][yPos]==1) {
        visited[xPos][yPos] = true;
        dfs(maps, xPos, yPos);
        visited[xPos][yPos] = false;
      }
    }

  }
}
