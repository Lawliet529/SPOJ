import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class BuildingBridges {
  private static final InputStream is = System.in;
  private static final byte[] inBuf = new byte[1024];
  private static int lenBuf = 0;
  private static int ptrBuf = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int numTests = nextInt();
    while (numTests-- > 0) {
      int numOfEndPoints = nextInt();
      int[][] coordinates = new int[numOfEndPoints][2];
      int[] dp = new int[numOfEndPoints];

      for (int i = 0; i < numOfEndPoints; i++) {
        coordinates[i][0] = nextInt();
      }

      for (int i = 0; i < numOfEndPoints; i++) {
        coordinates[i][1] = nextInt();
      }

      Arrays.sort(coordinates, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
      Arrays.fill(dp, Integer.MAX_VALUE);

      int maxBridge = 0;
      for (int i = 0; i < numOfEndPoints; i++) {
        int id = lowerBound(dp, coordinates[i][1]);
        dp[id] = coordinates[i][1];
        maxBridge = Math.max(maxBridge, id + 1);
      }

      sb.append(maxBridge).append('\n');
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.close();
  }

  public static int lowerBound(int[] array, int key) {
    int low = 0, high = array.length;
    int mid;
    while (low < high) {
      mid = (high + low) / 2;
      if (key < array[mid]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    if (low < array.length && array[low] < key) {
      low++;
    }
    return low;
  }

  public static int readByte() {
    if (lenBuf == -1) throw new InputMismatchException();

    if (ptrBuf >= lenBuf) {
      ptrBuf = 0;
      try {
        lenBuf = is.read(inBuf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
    }

    if (lenBuf <= 0) return -1;

    return inBuf[ptrBuf++];
  }

  public static int nextInt() {
    int num = 0;
    int b;

    boolean minus = false;
    while ((b = readByte()) != -1 &&
        !((b >= '0' && b <= '9') || b == '-')
    );
    if (b == '-') {
      minus = true;
      b = readByte();
    }

    while (true) {
      if (b >= '0' && b <= '9')
        num = (num << 3) + (num << 1) + (b - '0');
      else
        return minus ? -num : num;
      b = readByte();
    }
  }
}
