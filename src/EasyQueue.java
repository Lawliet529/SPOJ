import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyQueue {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    int[] queue = new int[t];
    int front = 0;
    int rear = -1;
    for (int i = 0; i < t; i++) {
      String s = br.readLine();
      if (s.charAt(0) == '1') {
        queue[++rear] = Integer.parseInt(s.substring(2));
      } else if (s.equals("2")) {
        if (front <= rear) {
          front++;
        }
      } else if (s.equals("3")) {
        bos.write((front > rear ? "Empty!\n" : queue[front] + "\n").getBytes());
      }
    }
    bos.flush();
  }
}
