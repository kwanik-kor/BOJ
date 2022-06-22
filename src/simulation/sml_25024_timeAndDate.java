package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25024
 */
public class sml_25024_timeAndDate {

    static final int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a < 24 && b < 60 ? "Yes " : "No ");

            if (0 < a && a <= 12) {
                if (0 < b && b <= days[a - 1]) {
                    bw.write("Yes\n");
                } else {
                    bw.write("No\n");
                }
            } else {
                bw.write("No\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
