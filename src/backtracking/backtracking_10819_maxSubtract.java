package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class backtracking_10819_maxSubtract {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static int ans = -801;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0, -1);

        bw.write(ans + "");
        bw.close();
        br.close();
    }

    static void backtracking(int sum, int cnt, int preIdx) {
        if (cnt == N) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            if (preIdx != -1) {
                backtracking(sum + Math.abs(arr[i] - arr[preIdx]), cnt + 1, i);
            } else {
                backtracking(sum, cnt + 1, i);
            }
            visit[i] = false;
        }
    }
}
