import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestCube {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    int t = Integer.parseInt(br.readLine());
    int[] cubes = new int[] {1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261};
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int j = 0;
      while (j < cubes.length && cubes[j] <= n) {
        j++;
      }
      bos.write(String.valueOf(j).getBytes());
      bos.write('\n');
    }
    bos.flush();
  }
}
