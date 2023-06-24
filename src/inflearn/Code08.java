package ps_strategy;

// 스프링 쿨러

public class Code08 {
  public static void main(String[] args) {
    Code08 sol = new Code08();

    int n1 = 8;
    int[] nums1 = {1, 1, 1, 2, 1, 1, 2, 1, 1};
    System.out.println(sol.solution(n1, nums1));

    int n2 = 4;
    int[] nums2 = {1, 2, 2, 0, 0};
    System.out.println(sol.solution(n2, nums2));

    int n3 = 5;
    int[] nums3 = {2, 0, 0, 0, 0, 2};
    System.out.println(sol.solution(n3, nums3));

    int n4 = 11;
    int[] nums4 = {1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1};
    System.out.println(sol.solution(n4, nums4));
  }

  public int solution(int n, int[] nums) {
    int answer = 0;

    int start = 0; //start는 초반에 0을 가리킨다.
    int end = 0; //end는 초반에 0을 가리킨다.

    int[][] ranges = new int[n+1][2];
    for(int i=0; i<nums.length; i++) {
      int s = i - nums[i];
      int e = i + nums[i];
      ranges[i][0] = Math.max(s, 0); //s값이 음수가 되면, 0을 넣는다.
      ranges[i][1] = Math.min(e, n); //e값이 n을 넘어가면, n을 넣는다.
    }

    for(int i=0; i<ranges.length; i++) {
      if(ranges[i][0] == ranges[i][1]) {
        continue;
      }

      if(ranges[i][0] > end) {
        return -1;
      }

      if(start < ranges[i][0]) {
        start = end;
        answer++;
      }

      if(end == n) {
        break;
      }

      if(end <= ranges[i][1]) {
        end = ranges[i][1];
      }

    }
    return answer;
  }

}
