package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2229
 */
public class dp_02229_makeGroup {

    static int N;
    static int[] score, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        score = new int[N + 1];
        sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            score[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int max = score[i];
            int min = score[i];
            for(int j = i; j >= 0; j--) {
                max = Math.max(max, score[j]);
                min = Math.min(min, score[j]);
                sum[i + 1] = Math.max(sum[i + 1], sum[j] + max - min);
            }
        }

        bw.write(sum[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
