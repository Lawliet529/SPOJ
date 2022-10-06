import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Arrange {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(reader.readLine());
      StringBuilder sb = new StringBuilder();
      long[] a = new long[n];
      String[] line = reader.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        a[j] = Long.parseLong(line[j]);
        if (a[j] == 1) {
          sb.append("1 ");
        }
      }
      Arrays.sort(a);
      if (n >= 2 && a[n - 1] == 3 && a[n - 2] == 2) {
        sb.append("2 3 ");
        for (int j = n - 3; j >= 0; j--) {
          if (a[j] == 1) {
            break;
          }
          sb.append(a[j]).append(" ");
        }
      } else {
        for (int j = n - 1; j >= 0; j--) {
          if (a[j] == 1) {
            break;
          }
          sb.append(a[j]).append(" ");
        }
      }
      System.out.println(sb);
    }
  }
}
