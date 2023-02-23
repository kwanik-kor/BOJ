package simulation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5342
 */
public class sml_05342_billing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> costs = new HashMap<>();
        costs.put("Paper", 57.99);
        costs.put("Printer", 120.5);
        costs.put("Planners", 31.25);
        costs.put("Binders", 22.5);
        costs.put("Calendar", 10.95);
        costs.put("Notebooks", 11.20);
        costs.put("Ink", 66.95);

        double tot = 0d;
        while (true) {
            String line = br.readLine();
            if (line.equals("EOI")) break;

            tot += costs.get(line);
        }

        bw.write(String.format("$%.2f", tot));

        bw.flush();
        bw.close();
        br.close();
    }
}
