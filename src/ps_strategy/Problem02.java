package ps_strategy;

// 고대어 사전, DFS
//TODO: 예상 결과와 다름
//INVALID HYPOTHESIS
//zyxwvutsrqponmjigklhfedcba
//zyxwvusrqpnmlkjhgfdeiotcba

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class AlphabetSort {
  static final String INVALID_STR = "INVALID HYPOTHESIS";
  ArrayList<String> words;
  int[][] graph = new int[26][26];
  int[] visited = new int[26];
  LinkedList<Integer> tSortDFSList = new LinkedList<>();

  public AlphabetSort(ArrayList<String> words) {
    super();
    this.words = words;
  }

  public boolean initGraph() {
    for(int w=0; w<words.size(); w++) {
      if(w+1 == this.words.size()) break;

      String cWord = this.words.get(w);
      String nWord = this.words.get(w+1);
      int len = Math.min(cWord.length(), nWord.length());

      for(int cmpIndex = 0; cmpIndex < len; cmpIndex++) {
        char cChar = cWord.charAt(cmpIndex);
        char nChar = nWord.charAt(cmpIndex);
        if(graph[nChar - 'a'][cChar - 'a'] == 1) {
          return false;
        }

        if(cChar != nChar) {
          graph[cChar - 'a'][nChar - 'a'] = 1;
          break;
        }
      }
    }
    return true;
  }

  public void dfs(int node) {
    int len = graph[node].length;
    visited[node] = 1;

    for(int i=0; i<len; i++) {
      if(graph[node][i] == 1 && visited[i] == 0) {
        dfs(i);
      }
    }
    tSortDFSList.add(0,node);
  }

  public void topologicalSortDFS() {
    for(int i=0; i< graph.length; i++) {
      if(visited[i] == 0) {
        dfs(i);
      }
    }
  }

  public String getDictionary() {
    if(!initGraph()) {
      return INVALID_STR;
    }

    topologicalSortDFS();

    String result = "";
    for (Iterator<Integer> it = tSortDFSList.iterator(); it.hasNext();) {
      char alpabet = (char) (it.next() + 'a');
      result += alpabet;
    }

    return result;
  }
}

public class Problem02 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int start = 1;
    while(start <= n) {
      int wordNumber = Integer.parseInt(br.readLine());
      ArrayList<String> words = new ArrayList<>(wordNumber);
      for (int w = 0; w < wordNumber; w++) {
        words.add(br.readLine());
      }

      AlphabetSort al = new AlphabetSort(words);
      bw.write(al.getDictionary());
      bw.newLine();

      start++;
    }

    br.close();
    bw.flush();
    bw.close();

  }
}
