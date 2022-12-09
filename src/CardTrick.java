import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardTrick {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine()); // number of test cases
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] bit = new int[n + 1];
      int[] ans = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        update(bit, i, 1);
      }
      int m = n, l = 1;
      for (int i = 1; i <= n; i++) {
        l = (l + i) % m;
        l = (l == 0) ? m : l;
        m--;
        int s = 1, e = n;
        while (s <= e) {
          int mid = (s + e) / 2;
          if (query(bit, mid) >= l) {
            e = mid - 1;
          } else if (query(bit, mid) < l) {
            s = mid + 1;
          }
        }
        ans[s] = i;
        update(bit, s, -1);
      }
      for (int i = 1; i <= n; i++) {
        bos.write((ans[i] + " ").getBytes());
      }
      bos.write("\n".getBytes());
    }
    bos.flush();
  }

  public static void update(int[] bit, int i, int v) {
    for (; i < bit.length; i += (i & -i)) {
      bit[i] += v;
    }
  }

  public static int query(int[] bit, int i) {
    int ans = 0;
    for (; i > 0; i -= (i & -i)) {
      ans += bit[i];
    }
    return ans;
  }
}
