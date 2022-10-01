import java.util.Scanner;
import java.util.Stack;

public class StreetParade {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    Stack<Integer> sideStreet = new Stack<>();
    int nextTruck;
    int nextExpectedTruck;

    while (true) {
      nextExpectedTruck = 1;
      n = scanner.nextInt();
      if (n == 0) {
        break;
      }

      while (n > 0) {
        if (!sideStreet.isEmpty() && sideStreet.peek() == nextExpectedTruck) {
          sideStreet.pop();
          nextExpectedTruck++;
          continue;
        }

        nextTruck = scanner.nextInt();
        if (nextTruck == nextExpectedTruck) {
          nextExpectedTruck++;
        } else {
          sideStreet.push(nextTruck);
        }
        n--;
      }
      while (!sideStreet.isEmpty() && sideStreet.peek() == nextExpectedTruck) {
        sideStreet.pop();
        nextExpectedTruck++;
      }

      if (sideStreet.isEmpty()) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
      sideStreet.clear();
    }
  }
}
