import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectedCountry {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(b);
      adj.get(b).add(a);
    }
    int[] visited = new int[n];
    int connected = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0) {
        connected++;
        dfs(adj, visited, i);
      }
    }
    bos.write((connected - 1 + "\n").getBytes());
    bos.flush();
  }

  public static void dfs(List<List<Integer>> adj, int[] visited, int pos) {
    visited[pos] = 1;
    for (int i = 0; i < adj.get(pos).size(); i++) {
      int u = adj.get(pos).get(i);
      if (visited[u] == 0) {
        dfs(adj, visited, u);
      }
    }
  }
}
