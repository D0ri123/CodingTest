package baekjoon.dfs;

//N-Queen

public class Code02 {
  public static int[] board;
  public static int count;
  public static void main(String[] args) {
    Code02 pro = new Code02();
    System.out.println(pro.solution(4));
  }

  public int solution(int n) {
    board = new int[n];
    dfs(0,n);
    return count;
  }

  public void dfs(int L, int n) {
    if(L == n) {
      count++;
      return;
    }
    for(int j=0; j<n; j++) {
      board[L] = j;
      if(isValid(L)) {
        dfs(L+1, n);
      }
    }
  }

  public static boolean isValid(int depth) {
    for (int j = 0; j < depth; j++) {
      if (board[depth] == board[j]) return false;
      if (Math.abs(depth - j) == Math.abs(board[depth] - board[j])) return false;
    }
    return true;
  }

}
