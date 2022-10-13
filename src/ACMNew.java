import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ACMNew {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String[] s = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[j] = Integer.parseInt(s[j]);
      }
      Arrays.sort(arr);
      int maxSum = Integer.parseInt(br.readLine());
      int a = n - 1;
      int b = n - 2;
      int c = n - 3;
      int sum = arr[a] + arr[b] + arr[c];
      while (sum > maxSum) {
        if (c == 0) {
          if (b == 1) {
            a--;
            b = a - 1;
          } else {
            b--;
          }
          c = b - 1;
        } else {
          c--;
        }
        sum = arr[a] + arr[b] + arr[c];
      }
      bos.write((sum + "\n").getBytes());
    }
    bos.flush();
  }
}
