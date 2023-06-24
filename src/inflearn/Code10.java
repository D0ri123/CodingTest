package ps_strategy;

//전투 게임

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Student implements Comparable<Student> {
  String team;//학생이 소속된 팀명
  int power;//학생의 공격력
  int order;//학생의 순서

  public Student(String input) {
    String[] in = input.split(" ");
    this.team = in[0];
    this.power = Integer.parseInt(in[1]);
  }

  public void setOrder(int idx) {
    this.order = idx;
  }

  //공격력을 기준으로 오름차순 정렬한다.
  @Override
  public int compareTo(Student student) {
    return this.power - student.power;
  }
}

public class Code10 {
  public int[] solution(String[] students){
    int n = students.length;
    Student[] arr = new Student[n];

    int[] answer = new int[n];
    Map<String, Integer> powerTable = new HashMap<>();

    //Student 객체로 생성하여 넣는다.
    for(int i=0; i<n; i++) {
      arr[i] = new Student(students[i]);
      arr[i].setOrder(i);
    }

    Arrays.sort(arr);

    //초기화
    answer[arr[0].order] = 0;
    powerTable.put(arr[0].team, arr[0].power);

    int p = arr[0].power;
    for(int i=1; i<arr.length; i++) {
      if(arr[i].power > p) {
        answer[arr[i].order] = p;
        powerTable.put(arr[i].team,
            powerTable.getOrDefault(arr[i].team, 0) + arr[i].power); // 누적합
      }
    }
    return answer;
  }

  public static void main(String[] args){
    Code10 T = new Code10();
    System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
  }
}