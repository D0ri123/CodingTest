package programmers;

//풍선 터뜨리기

public class Problem20 {
  public static void main(String[] args) {
    Problem20 pro = new Problem20();
    int[] a = {9, -1, -5};
    System.out.println(pro.solution(a));

    int[] b = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
    System.out.println(pro.solution(b));
  }

  public int solution(int[] a) {
    int answer = 0;

    int[] leftMin = new int[a.length];
    int[] rightMin = new int[a.length];

    leftMin[0] = a[0];
    for(int i=1; i<a.length; i++) {
      leftMin[i] = Math.min(leftMin[i-1], a[i]);
    }

    rightMin[a.length-1] = a[a.length-1];
    for(int i=a.length-2; i>=0; i--) {
      rightMin[i] = Math.min(rightMin[i+1], a[i]);
    }

    for(int i=0; i<a.length; i++) {
      if(a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
        answer++;
      }
    }

    return answer;
  }

}
