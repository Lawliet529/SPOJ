import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HandleTheFans {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] tree = new int[n * 4];
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (s.equals("find")) {
        bos.write((query(tree, 1, 1, n, a, b) + "\n").getBytes());
      } else {
        update(tree, 1, 1, n, a, a, b);
      }
    }
    bos.flush();
  }

  public static void update(int[] tree, int pos, int b, int e, int i, int j, int val) {
    if (b > e || b > j || e < i) {
      return;
    }
    if (b >= i && e <= j) {
      tree[pos] += val;
      return;
    }
    int m = (b + e) / 2;
    int l = pos * 2;
    int r = l + 1;
    update(tree, l, b, m, i, j, val);
    update(tree, r, m + 1, e, i, j, val);
    tree[pos] = tree[l] + tree[r];
  }

  public static int query(int[] tree, int pos, int b, int e, int i, int j) {
    if (b > e || b > j || e < i) {
      return 0;
    }
    if (b >= i && e <= j) {
      return tree[pos];
    }
    int m = (b + e) / 2;
    int l = pos * 2;
    int r = l + 1;
    return query(tree, l, b, m, i, j) + query(tree, r, m + 1, e, i, j);
  }
}
