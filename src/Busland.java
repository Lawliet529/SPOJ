import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Busland {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    LinkedList<Integer> queue = new LinkedList<>();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      bos.write(("Case " + (i + 1) + ":\n").getBytes());
      int n = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        String[] query = br.readLine().split(" ");
        switch (query[0]) {
          case "1":
            if (query[1].equals("B")) {
              queue.addLast(Integer.parseInt(query[2]));
            } else {
              queue.addFirst(Integer.parseInt(query[2]));
            }
            break;
          case "2":
            if (query[1].equals("B")) {
              queue.removeLast();
            } else {
              queue.removeFirst();
            }
            break;
          case "3":
            if (query[1].equals("D")) {
              bos.write((queue.get(Integer.parseInt(query[2]) - 1) + "\n").getBytes());
            } else {
              bos.write(((queue.indexOf(Integer.parseInt(query[2])) + 1) + "\n").getBytes());
            }
        }
      }
      queue.clear();
    }
    bos.flush();
  }
}
