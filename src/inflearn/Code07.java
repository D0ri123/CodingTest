package ps_strategy;

// 이동 횟수
import java.util.Arrays;

public class Code07 {
  public static void main(String[] args) {
    Code07 sol = new Code07();

    int[] nums1 = {2, 5, 3, 4, 2, 3};
    System.out.println(sol.solution(nums1));

    int[] nums2 = {2, 3, 4, 5};
    System.out.println(sol.solution(nums2));

    int[] nums3 = {5,4,3,1,2,1,2};
    System.out.println(sol.solution(nums3));
  }

  public int solution(int[] nums) {
    int answer = 0;
    int lt = 0;
    int rt = nums.length-1;

    Arrays.sort(nums);

    while(lt<=rt) {
      if(lt == rt) {
        answer++;
        break;
      }
      if(nums[lt] + nums[rt] <= 5) {
        lt++;
        rt--;
        answer++;
      } else{
        rt--;
        answer++;
      }
    }
    return answer;
  }

}
