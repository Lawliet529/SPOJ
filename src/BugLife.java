import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BugLife {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());
    for (int i = 1; i <= t; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      List<List<Integer>> interactions = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        interactions.add(new ArrayList<>());
      }
      for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        interactions.get(a).add(b);
        interactions.get(b).add(a);
      }
      int[] colors = new int[n];
      boolean isBipartite = true;
      for (int j = 0; j < n; j++) {
        if (colors[j] == 0) {
          isBipartite = isBipartite && dfs(interactions, colors, j, 1);
        }
      }
      bos.write(("Scenario #" + i + ":\n").getBytes());
      if (isBipartite) {
        bos.write("No suspicious bugs found!\n".getBytes());
      } else {
        bos.write("Suspicious bugs found!\n".getBytes());
      }
    }
    bos.flush();
  }

  public static boolean dfs(List<List<Integer>> interactions, int[] colors, int pos, int color) {
    if (colors[pos] != 0) {
      return colors[pos] == color;
    }
    colors[pos] = color;
    for (int i = 0; i < interactions.get(pos).size(); i++) {
      if (!dfs(interactions, colors, interactions.get(pos).get(i), -color)) {
        return false;
      }
    }
    return true;
  }
}
