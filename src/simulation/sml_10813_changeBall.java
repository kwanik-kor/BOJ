package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10813
 */
public class sml_10813_changeBall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] balls = new int[n];
        for (int i = 1; i <= n; i++) {
            balls[i - 1] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int tmp = balls[a];
            balls[a] = balls[b];
            balls[b] = tmp;
        }

        for (int i = 0; i < n; i++) {
            bw.write(balls[i] + " ");
        }

        bw.close();
        br.close();
    }
}
