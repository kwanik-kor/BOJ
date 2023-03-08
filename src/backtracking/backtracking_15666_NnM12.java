package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15666
 */
public class backtracking_15666_NnM12 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = lineToSortedDistinctArray(br.readLine());

        backtracking(arr, 0, 0, "");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void backtracking(int[] arr, int start, int cnt, String seq) {
        if (cnt == M) {
            sb.append(seq.trim()).append("\n");
            return;
        }

        for (int i = start, n = arr.length; i < n; i++) {
            backtracking(arr, i, cnt + 1, seq + arr[i] + " ");
        }
    }

    static int[] lineToSortedDistinctArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .toArray();
    }

}
