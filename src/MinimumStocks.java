import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MinimumStocks {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    HashMap<String, Integer> stocks = new HashMap<>();
    int day = 0;
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      day++;
      String[] inst = br.readLine().split(" ");
      if ("3".equals(inst[0])) {
        int min = Integer.MAX_VALUE;
        String minStock = "";
        for (String stock : stocks.keySet()) {
          if (stocks.get(stock) < min) {
            minStock = stock;
            min = stocks.get(stock);
          }
        }
        bos.write((minStock + " " + day + "\n").getBytes());
        stocks.remove(minStock);
      } else {
        stocks.put(inst[1], Integer.parseInt(inst[2]));
      }
    }
    bos.flush();
  }
}
