import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SocialNetworkCommunity {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[] parent = new int[n + 1];
    int[] size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      switch (query[0]) {
        case "A":
          join(parent, size, Integer.parseInt(query[1]), Integer.parseInt(query[2]), m);
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
          bos.write((size[rootOf(parent, Integer.parseInt(query[1]))] + "\n").getBytes());
      }
    }
    bos.flush();
  }

  private static void join(int[] parent, int[] size, int x, int y, int max) {
    int rootX = rootOf(parent, x);
    int rootY = rootOf(parent, y);
    if (rootX == rootY || size[rootX] + size[rootY] > max) {
      return;
    }
    if (size[rootX] > size[rootY]) {
      parent[rootY] = rootX;
      size[rootX] += size[rootY];
    } else {
      parent[rootX] = rootY;
      size[rootY] += size[rootX];
    }
  }

  private static int rootOf(int[] parent, int a) {
    while (parent[a] != parent[parent[a]]) {
      parent[a] = parent[parent[a]];
    }
    return parent[a];
  }
}
