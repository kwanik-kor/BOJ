package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: acmicpc.net/problem/10810
 */
public class sml_10810_putBall {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());
            for (int idx = i; idx <= j; idx++) {
                arr[idx] = k;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.close();
        br.close();
    }
}
