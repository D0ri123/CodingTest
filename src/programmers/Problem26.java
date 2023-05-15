package programmers;

//호텔 방 배정

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem26 {
  public static Map<Long, Long> reserved = new HashMap<>();
  public static void main(String[] args) {
    Problem26 pro = new Problem26();

    long k = 10;
    long[] roomNumber = {1,3,4,1,3,1};
    System.out.println(Arrays.toString(pro.solution(k, roomNumber)));
  }

  public long[] solution(long k, long[] roomNumber) {
    long[] ans = new long[roomNumber.length];
    for(int i=0; i<roomNumber.length; i++) {
      ans[i] = findEmptyRoom(roomNumber[i]);
    }
    return ans;
  }

  public long findEmptyRoom(long request){
    if(!reserved.containsKey(request)){ //아직 빈 방이라면 reserved에 넣어준다.
      reserved.put(request, request+1);
      return request;
    }

    long nextRoom = reserved.get(request);
    long emptyRoom = findEmptyRoom(nextRoom);
    reserved.put(request, emptyRoom);
    return emptyRoom;
  }
}
