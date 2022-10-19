import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Busland {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int size = 200010;
    int[] queue = new int[size];
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      bos.write(("Case " + (i + 1) + ":\n").getBytes());
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = Integer.parseInt(br.readLine());
      int head = 0, tail = 0;
      for (int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        switch (type) {
          case 1:
            int id = Integer.parseInt(st.nextToken());
            if (str.equals("B")) {
              queue[tail] = id;
              map.put(id, tail);
              tail = (tail + 1) % size;
            } else {
              head = (head == 0) ? size - 1 : head - 1;
              queue[head] = id;
              map.put(id, head);
            }
            break;
          case 2:
            if (str.equals("B")) {
              tail = (tail == 0) ? size - 1 : tail - 1;
            } else {
              head = (head + 1) % size;
            }
            break;
          case 3:
            int x = Integer.parseInt(st.nextToken());
            if (str.equals(("D"))) {
              bos.write((queue[(head + x - 1) % size] + "\n").getBytes());
            } else {
              int idx = map.get(x);
              if (idx >= head) {
                bos.write(((idx - head + 1) + "\n").getBytes());
              } else {
                bos.write(((idx + size - head + 1) + "\n").getBytes());
              }
            }
        }
      }
    }
    bos.flush();
  }
}
