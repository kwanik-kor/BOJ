package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15656
 */
public class backtracking_15656_NnM7 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted().toArray();

        recursive(0, 0, "");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void recursive(int start, int cnt, String str) {
        if (cnt == M) {
            sb.append(str + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            recursive(i, cnt + 1, str + arr[i] + (cnt == M - 1 ? "" : " "));
        }
    }
}
