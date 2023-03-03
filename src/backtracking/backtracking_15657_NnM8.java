package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backtracking_15657_NnM8 {
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
                .sorted()
                .toArray();

        backtracking(0, 0, "");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void backtracking(int cnt, int start, String str) {
        if (cnt == M) {
            sb.append(str.trim()).append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            backtracking(cnt + 1, i, str + arr[i] + " ");
        }
    }
}
