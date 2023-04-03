package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10093
 */
public class sml_10093_number {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if (a == b || Math.abs(a - b) == 1L) {
            bw.write("0");
        } else {
            long max = Math.max(a, b);
            long min = Math.min(a, b);

            bw.write(max - min - 1 + "\n");

            for (long i = min + 1; i < max; i++) {
                bw.write(i + " ");
            }
        }
        bw.close();
        br.close();
    }

}
