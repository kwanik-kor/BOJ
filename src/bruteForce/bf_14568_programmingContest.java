package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14568
 */
public class bf_14568_programmingContest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int a = 1; a <= N - 2; a++) {
            for (int b = a + 2; b <= N; b++) {
                int c = N - a - b;
                if (c <= 0 || c % 2 == 1) {
                    continue;
                }
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
