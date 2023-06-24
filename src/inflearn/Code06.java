package ps_strategy;

//침몰하는 타이타닉

import java.util.Arrays;

public class Code06 {

  public static void main(String[] args) {
    Code06 sol = new Code06();

    int[] nums1 = {90, 50, 70, 100, 60};
    int m1 = 140;
    System.out.println(sol.solution(nums1, m1));

    int[] nums2 = {86, 95, 107, 67, 38, 49, 116, 22, 78, 53};
    int m2 = 150;
    System.out.println(sol.solution(nums2, m2));

    int[] nums3 = {68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81};
    int m3 = 120;
    System.out.println(sol.solution(nums3, m3));
  }

  public int solution(int[] nums, int m) {
    int answer = 0;
    Arrays.sort(nums);
    int lt = 0;
    int rt = nums.length - 1;

    while(lt<rt) {
      if(nums[lt] + nums[rt] <= m) {
        lt++;
        rt--;
        answer++;
      } else {
        rt--;
        answer++;
      }
    }
    return answer;
  }

}
