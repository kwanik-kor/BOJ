package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16427
 */
public class sml_16427_timeLimits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        float max = 0f;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Float.parseFloat(st.nextToken()));
        }

        max = (float) Math.ceil(max * s / 1000f);
        bw.write(String.format("%.0f", max));
        bw.flush();
        bw.close();
        br.close();
    }
}
