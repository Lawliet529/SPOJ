import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AirCombat {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    StringTokenizer st;
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int z1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int z2 = Integer.parseInt(st.nextToken());
      int[][][] diff = new int[x2 - x1 + 2][y2 - y1 + 2][z2 - z1 + 2];
      int n = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        String type = st.nextToken();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        if (type.equals("U")) {
          int r = Integer.parseInt(st.nextToken());
          int xMin = Math.max(x - r, x1);
          int xMax = Math.min(x + r, x2);
          int yMin = Math.max(y - r, y1);
          int yMax = Math.min(y + r, y2);
          int zMin = Math.max(z - r, z1);
          int zMax = Math.min(z + r, z2);
          diff[xMin - x1][yMin - y1][zMin - z1]++;
          diff[xMin - x1][yMin - y1][zMax + 1 - z1]--;
          diff[xMin - x1][yMax + 1 - y1][zMin - z1]--;
          diff[xMin - x1][yMax + 1 - y1][zMax + 1 - z1]++;
          diff[xMax + 1 - x1][yMin - y1][zMin - z1]--;
          diff[xMax + 1 - x1][yMin - y1][zMax + 1 - z1]++;
          diff[xMax + 1 - x1][yMax + 1 - y1][zMin - z1]++;
          diff[xMax + 1 - x1][yMax + 1 - y1][zMax + 1 - z1]--;
        } else {
          int x0 = x - x1;
          int y0 = y - y1;
          int z0 = z - z1;
          int sum = 0;
          for (int k = 0; k <= x0; k++) {
            for (int l = 0; l <= y0; l++) {
              for (int m = 0; m <= z0; m++) {
                sum += diff[k][l][m];
              }
            }
          }
          if (sum % 2 == 0) {
            bos.write("Enemy\n".getBytes());
          } else {
            bos.write("Friend\n".getBytes());
          }
        }
      }
      bos.flush();
    }
  }
}
