import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunningMedian {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      while (true) {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
          break;
        }
        if (n != -1) {
          if (list.isEmpty()) {
            list.add(n);
          } else {
            int j = 0;
            while (j < list.size() && list.get(j) < n) {
              j++;
            }
            list.add(j, n);
          }
        } else {
          if (list.size() % 2 == 0) {
            bos.write(String.valueOf(list.remove(list.size() / 2 - 1)).getBytes());
          } else {
            bos.write(String.valueOf(list.remove(list.size() / 2)).getBytes());
          }
          bos.write('\n');
        }
      }
    }
    bos.flush();
  }
}
