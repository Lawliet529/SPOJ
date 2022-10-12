import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EasyStack {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        bw.write(top == -1 ? "Empty!\n" : stack[top] + "\n");
      }
    }
    bw.flush();
  }
}
