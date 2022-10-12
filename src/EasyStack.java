import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStack {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    int[] stack = new int[t];
    int top = -1;
    for (int i = 0; i < t; i++) {
      String s = br.readLine();
      if (s.charAt(0) == '1') {
        stack[++top] = Integer.parseInt(s.substring(2));
      } else if (s.equals("2")) {
        if (top >= 0) {
          top--;
        }
      } else if (s.equals("3")) {
        bos.write((top == -1 ? "Empty!\n" : stack[top] + "\n").getBytes());
      }
    }
    bos.flush();
  }
}
