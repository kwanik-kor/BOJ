package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15663
 */
public class backtracking_15663_NnM9 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static Set<String> dup = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = lineToSortedIntArr(br.readLine());

        visit = new boolean[arr.length];
        backtracking(0, "");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int[] lineToSortedIntArr(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

    static void backtracking(int cnt, String str) {
        if (cnt == M) {
            String type = str.trim();
            if (!dup.contains(type)) {
                dup.add(type);
                sb.append(type).append("\n");
            }
            return;
        }

        for (int i = 0, n = arr.length; i < n; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            backtracking(cnt + 1, str + arr[i] + " ");
            visit[i] = false;
        }
    }
}
