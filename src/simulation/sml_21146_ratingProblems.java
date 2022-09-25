package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/21146
 */
public class sml_21146_ratingProblems {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        float min = 0f, max = 0f;
        for (int i = 0; i < k; i++) {
            max += Float.parseFloat(br.readLine());
        }
        min = max;
        min += (-3f) * (n - k);
        max += 3f * (n - k);
        bw.write(String.format("%.4f %.4f", min / n, max / n));
        bw.flush();
        bw.close();
        br.close();
    }
}
