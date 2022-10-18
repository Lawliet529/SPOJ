import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocialNetworkCommunity {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]) + 1;
    int m = Integer.parseInt(nm[1]);
    int[] parent = new int[n];
    for (int i = 1; i < n; i++) {
      parent[i] = i;
    }
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      switch (query[0]) {
        case "A":
          join(parent, Integer.parseInt(query[1]), Integer.parseInt(query[2]), m);
          break;
        case "E":
          if (rootOf(parent, Integer.parseInt(query[1]))
              == rootOf(parent, Integer.parseInt(query[2]))) {
            bos.write("Yes\n".getBytes());
          } else {
            bos.write("No\n".getBytes());
          }
          break;
        case "S":
          int root = rootOf(parent, Integer.parseInt(query[1]));
          int count = 0;
          for (int j = 1; j < n; j++) {
            if (root == rootOf(parent, j)) {
              count++;
            }
          }
          bos.write((count + "\n").getBytes());
      }
    }
    bos.flush();
  }

  private static void join(int[] parent, int x, int y, int max) {
    int rootX = rootOf(parent, x);
    int rootY = rootOf(parent, y);
    if (rootX == rootY) {
      return;
    }
    int countX = 0;
    int countY = 0;
    int n = parent.length;
    for (int i = 1; i < n; i++) {
      if (rootOf(parent, i) == rootX) {
        countX++;
      }
      if (rootOf(parent, i) == rootY) {
        countY++;
      }
    }
    if (countX + countY > max) {
      return;
    }
    if (countX >= countY) {
      parent[rootY] = rootX;
    } else {
      parent[rootX] = rootY;
    }
  }

  private static int rootOf(int[] parent, int a) {
    if (parent[a] == a) {
      return a;
    }
    return parent[a] = rootOf(parent, parent[a]);
  }
}
