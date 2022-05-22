package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6779
 */
public class math_06779_whoHasSeenTheWind {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int h = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int ans = -1;
        for (int t = 1; t <= M; t++) {
            if (Math.pow(t, 4) * (-6d) + h * Math.pow(t, 3) + 2 * Math.pow(t, 2) + t <= 0d) {
                ans = t;
                break;
            }
        }

        bw.write(ans == -1? "The balloon does not touch ground in the given time." : String.format("The balloon first touches ground at hour: %d", ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
