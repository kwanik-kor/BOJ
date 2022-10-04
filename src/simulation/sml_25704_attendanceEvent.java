package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25704
 */
public class sml_25704_attendanceEvent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        List<Integer> prices = new ArrayList<>();
        prices.add(P);

        if (P >= 5) {
            prices.add(Math.max(P - 500, 0));
        }
        if (P >= 10) {
            prices.add(P * 90 / 100);
        }
        if (P >= 15) {
            prices.add(Math.max(P - 2000, 0));
        }
        if (P >= 20) {
            prices.add(P * 75 / 100);
        }

        bw.write(Collections.min(prices) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
