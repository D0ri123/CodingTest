package inflearn;

//한번만 사용한 최초 문자

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Code12 {
  public int solution(String s){
    AtomicInteger answer = new AtomicInteger(Integer.MAX_VALUE);
    HashMap<Character, Integer> map = new HashMap<>();

    for(char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch,0)+1);
    }

    map.forEach((character, count) -> {
      if(count == 1) {
        answer.set(Math.min(answer.get(), s.indexOf(character) + 1));
      }
    });


    if(answer.get() == Integer.MAX_VALUE) {
      return -1;
    }
    return answer.get();
  }

  public static void main(String[] args){
    Code12 T = new Code12();
    System.out.println(T.solution("statitsics"));
    System.out.println(T.solution("aabb"));
    System.out.println(T.solution("stringshowtime"));
    System.out.println(T.solution("abcdeabcdfg"));
  }
}
