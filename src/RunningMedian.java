import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RunningMedian {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      int n;
      while (true) {
        n = Integer.parseInt(br.readLine());
        if (n == 0) {
          break;
        }
        if (n == -1) {
          if (list.size() != 0) {
            int start = 0;
            int end = list.size() - 1;
            int k = list.size() / 2 - (list.size() % 2 == 0 ? 1 : 0);
            while (true) {
              int pivot = list.get(end);
              int j = start;
              for (int l = start; l < end; l++) {
                if (list.get(l) < pivot) {
                  int temp = list.get(l);
                  list.set(l, list.get(j));
                  list.set(j, temp);
                  j++;
                }
              }
              list.set(end, list.get(j));
              list.set(j, pivot);
              if (j == k) {
                System.out.println(list.remove(j));
                break;
              } else if (j < k) {
                start = j + 1;
              } else {
                end = j - 1;
              }
            }
          }
          continue;
        }
        list.add(n);
      }
    }
  }
}
