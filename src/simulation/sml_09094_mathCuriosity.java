package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9094
 */
public class sml_09094_mathCuriosity {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int a = 1; a < n - 1; a++) {
                for (int b = a + 1; b < n; b++) {
                    cnt += (a * a + b * b + m) % (a * b) == 0 ? 1 : 0;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
