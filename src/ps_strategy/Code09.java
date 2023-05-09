package ps_strategy;

//꽃이 피는 최단시간

import java.util.Arrays;

class Flower implements Comparable<Flower> {
  int plantTime;
  int growTime;

  public Flower(int plantTime, int growTime) {
    this.plantTime = plantTime;
    this.growTime = growTime;
  }

  // growTime을 기준으로 내림차순, planTime을 기준으로 내림차순
  @Override
  public int compareTo(Flower flower) {
    if(this.growTime == flower.growTime){
      return flower.plantTime - this.plantTime;
    }
    return flower.growTime - this.growTime;
  }
}

public class Code09 {
  public static void main(String[] args) {
    Code09 T = new Code09();

    System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
    System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
    System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
    System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
    System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
  }

  public int solution(int[] plantTime, int[] growTime){
    int planning = 0;
    int size = plantTime.length;
    Flower[] seeds = new Flower[size];

    for(int i=0; i<size; i++) {
      seeds[i] = new Flower(plantTime[i], growTime[i]);
    }

    Arrays.sort(seeds);

    //모든 종류의 꽃을 심는 실제 날짜로 갱신한다.
    for(Flower flower : seeds) {
      planning += flower.plantTime;
      flower.plantTime = planning;
    }

    int max = 0;
    for(Flower plannedFlower : seeds) {
      plannedFlower.growTime += plannedFlower.plantTime;
      max = Math.max(max, plannedFlower.growTime);
    }

    return max;
  }

}
