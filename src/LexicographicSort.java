import java.util.Arrays;
import java.util.Scanner;

public class LexicographicSort {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      char[] alphabet = scanner.next().toCharArray();
      int n = scanner.nextInt();
      String[] words = new String[n];
      for (int j = 0; j < n; j++) {
        words[j] = scanner.next();
      }

      Arrays.sort(
          words,
          (a, b) -> {
            int min = Math.min(a.length(), b.length());
            for (int j = 0; j < min; j++) {
              if (a.charAt(j) != b.charAt(j)) {
                for (char c : alphabet) {
                  if (c == a.charAt(j)) {
                    return -1;
                  }
                  if (c == b.charAt(j)) {
                    return 1;
                  }
                }
              }
            }
            return a.length() - b.length();
          });

      for (String word : words) {
        System.out.println(word);
      }
      System.out.println();
    }
  }
}
