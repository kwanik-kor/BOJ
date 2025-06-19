package simulation;

import java.io.*;
import java.util.Arrays;

public class sml_18110_solvedac {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        final int[] values = new int[n];
        int tot = 0;

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
            tot += values[i];
        }

        if (n == 0) {
            bw.write("0");
        } else if (n <= 3) {
            bw.write(Math.round(((float) tot) / n) + "");
        } else {
            Arrays.sort(values);
            int except = Math.round(n * 0.15f);
            for (int i = 0; i < except; i++) {
                tot -= values[i];
                tot -= values[n - 1 - i];
            }

            bw.write(Math.round(((float) tot) / (n - except * 2)) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
