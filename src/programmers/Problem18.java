package programmers;

// 햄버거 만들기

import java.util.Stack;
public class Problem18 {

  public static void main(String[] args) {
    int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//    int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
    Problem18 pro = new Problem18();
    System.out.println(pro.solution(ingredient));

  }

  public int solution(int[] ingredient) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for(int num : ingredient) {
      stack.push(num);

      if(stack.size() >= 4) {
        if(stack.get(stack.size() - 4) == 1
        && stack.get(stack.size() - 3) == 2
        && stack.get(stack.size() - 2) == 3
        && stack.get(stack.size() - 1) == 1) {
          answer++;

          for(int i=1; i<=4; i++) {
            stack.pop();
          }
        }
      }
    }
    return answer;
  }
}
