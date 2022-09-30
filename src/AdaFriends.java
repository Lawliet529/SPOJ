import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AdaFriends {

  public static void main(String[] args) {
    // Read input
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    int k = scan.nextInt();
    scan.nextLine();
    HashMap<String, Long> map = new HashMap<>();
    for (int i = 0; i < q; i++) {
      String name = scan.next();
      map.put(name, map.getOrDefault(name, 0L) + scan.nextLong());
      scan.nextLine();
    }
    scan.close();

    // Extract all values and sort them
    long[] values = new long[map.size()];
    int i = 0;
    for (long value : map.values()) {
      values[i++] = value;
    }
    Arrays.sort(values);

    // Compute the sum of the last k values
    long sum = 0;
    k = Math.min(k, values.length);
    for (int j = values.length - 1; j >= values.length - k; j--) {
      sum += values[j];
    }
    System.out.println(sum);
  }
}
