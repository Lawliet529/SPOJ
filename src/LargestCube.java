import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestCube {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i ++) {
      bos.write(((int) Math.cbrt(Integer.parseInt(br.readLine())) + "\n").getBytes());
    }
    bos.flush();
  }
}
