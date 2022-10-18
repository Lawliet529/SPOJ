import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class AdaQueue {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int q = Integer.parseInt(br.readLine());
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    boolean isReversed = false;
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      switch (query[0]) {
        case "back":
          if (!queue.isEmpty()) {
            if (isReversed) {
              bos.write((queue.remove()+ "\n").getBytes());
            } else {
              bos.write((queue.removeLast() + "\n").getBytes());
            }
          } else {
            bos.write("No job for Ada?\n".getBytes());
          }
          break;
        case "front":
          if (!queue.isEmpty()) {
            if (isReversed) {
              bos.write((queue.removeLast() + "\n").getBytes());
            } else {
              bos.write((queue.remove() + "\n").getBytes());
            }
          } else {
            bos.write("No job for Ada?\n".getBytes());
          }
          break;
        case "reverse":
          isReversed = !isReversed;
          break;
        case "push_back":
          if (isReversed) {
            queue.push(Integer.parseInt(query[1]));
          } else {
            queue.add(Integer.parseInt(query[1]));
          }
          break;
        case "toFront":
          if (isReversed) {
            queue.add(Integer.parseInt(query[1]));
          } else {
            queue.push(Integer.parseInt(query[1]));
          }
          break;
      }
    }
    bos.flush();
  }
}
