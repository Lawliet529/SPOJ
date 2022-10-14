import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialPrime {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      switch (n) {
        case 2:
        case 3:
        case 5:
        case 7:
        case 23:
        case 719:
        case 5039:
          bos.write("YES\n".getBytes());
          break;
        default:
          bos.write("NO\n".getBytes());
      }
      bos.flush();
    }
  }
}
