package programmers;

// 단속 카메라

import java.util.Arrays;

class Car implements Comparable<Car> {
  int in;
  int out;

  public Car(int in, int out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public int compareTo(Car car) {
    if(this.in == car.in) {
      return this.out - car.out;
    }
    return this.in - car.in;
  }
}

public class Problem05 {
  public static Car[] arr;
  public static void main(String[] args) {
    Problem05 sol = new Problem05();
    int[][] routes = {{2,2},{0,1},{-10,9}};

    arr = new Car[routes.length];
    for(int i=0; i<routes.length ; i++) {
      Car car = new Car(routes[i][0], routes[i][1]);
      arr[i] = car;
    }

    Arrays.sort(arr);
    System.out.println(sol.solution());
  }

  public int solution() {
    int answer = 1;
    int bound = arr[0].out;

    for(int i=1; i<arr.length; i++) {
      if(bound >= arr[i].out) {
        bound = arr[i].out;
      }

      if(bound < arr[i].in) {
        answer ++;
        bound = arr[i].out;
      }
    }
    return answer;
  }


}
