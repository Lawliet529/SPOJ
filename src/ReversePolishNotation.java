import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < t; i++) {
      String s = scan.nextLine();
      System.out.println(transform(s));
    }
    scan.close();
  }

  private static String transform(String s) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetter(c)) {
        sb.append(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
          sb.append(stack.pop());
        }
        stack.push(c);
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  private static int priority(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
      default:
        return 0;
    }
  }
}
