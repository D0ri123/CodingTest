package programmers;

//가장 긴 팰린드롬

public class Problem11 {
  public static String[] arr;
  public static void main(String[] args) {
    String s = "abacde";

    Problem11 sol = new Problem11();
    System.out.println(sol.solution(s));
  }

  public int solution(String s) {
    String[] arr = s.split("");
    int result = Integer.MIN_VALUE;

    String initReversed = new StringBuilder(s).reverse().toString();

    if(s.length() < 2) {
      return 1;
    } else if(s.equals(initReversed)) {
      return s.length();
    } else {
      int lt = 0;
      int rt = 1;

      while(lt != s.length()-2) {
        if(rt==s.length()-1) {
          lt++;
          rt = lt+1;
        }
        if(!arr[lt].equals(arr[rt])) {
          rt++;
        } else {
          String str = connect(lt, rt, arr);
          String reversed = new StringBuilder(str).reverse().toString();
          if(str.equals(reversed)) {
            result = Math.max(result, str.length());
          }
          rt++;
        }
      }
    }
    return result;
  }

  private String connect(int lt, int rt, String[] arr) {
    StringBuilder sb = new StringBuilder();

    int index=lt;
    while(index <= rt) {
      sb.append(arr[index]);
      index++;
    }

    return sb.toString();
  }
}