import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FibonacciPrime {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    ArrayList<Integer> fib = new ArrayList<>();
    fib.add(2);
    fib.add(3);
    boolean isFib;
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      while (fib.get(fib.size() - 1) < n) {
        fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
      }
      isFib = fib.contains(n);
      if (isFib && isPrime(n)) {
        bos.write("YES\n".getBytes());
      } else {
        bos.write("NO\n".getBytes());
      }
    }
    bos.flush();
  }

  private static boolean isPrime(int i) {
    if (i < 2) {
      return false;
    }
    for (int j = 2; j <= Math.sqrt(i); j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }
}
