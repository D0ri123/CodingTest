package inflearn.hashing_parsing;

//같은 빈도수 만들기

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code02 {
  public int[] solution(String s){
    int[] answer = new int[5];
    char[] chars = {'a','b','c','d','e'};

    Map<Character, Integer> map = new HashMap<>();

    int count = s.chars()
        .mapToObj(ch -> (char) ch)
        .peek(ch -> map.put(ch, map.getOrDefault(ch, 0) + 1))
        .mapToInt(ch -> map.get(ch))
        .max()
        .orElse(0);

    answer = new String(chars).chars()
        .mapToObj(i -> (char)i)
        .mapToInt(ch -> count - map.getOrDefault(ch, 0))
        .toArray();

    return answer;
  }

  public static void main(String[] args){
    Code02 T = new Code02();
    System.out.println(Arrays.toString(T.solution("aaabc")));
    System.out.println(Arrays.toString(T.solution("aabb")));
    System.out.println(Arrays.toString(T.solution("abcde")));
    System.out.println(Arrays.toString(T.solution("abcdeabc")));
    System.out.println(Arrays.toString(T.solution("abbccddee")));
  }
}
