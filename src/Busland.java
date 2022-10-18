import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class Busland {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      bos.write(("Case " + (i + 1) + ":\n").getBytes());
      int n = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        String[] query = br.readLine().split(" ");
        switch (query[0]) {
          case "1":
            if (query[1].equals("B")) {
              queue.add(Integer.parseInt(query[2]));
            } else {
              queue.push(Integer.parseInt(query[2]));
            }
            break;
          case "2":
            if (query[1].equals("B")) {
              queue.removeLast();
            } else {
              queue.remove();
            }
            break;
          case "3":
            if (query[1].equals("D")) {
              bos.write((List.copyOf(queue).get(Integer.parseInt(query[2])-1) + "\n").getBytes());
            } else {
              Iterator<Integer> iterator = queue.iterator();
              int index = 0;
              while (iterator.hasNext()) {
                if (iterator.next() == Integer.parseInt(query[2])) {
                  bos.write((index + 1 + "\n").getBytes());
                  break;
                }
                index++;
              }
            }
        }
      }
      queue.clear();
    }
    bos.flush();
  }
}
