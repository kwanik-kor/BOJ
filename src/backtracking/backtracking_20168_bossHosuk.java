package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class backtracking_20168_bossHosuk {
    static int N, start, end, money;
    static int[][] dist = new int[11][11];
    static boolean[] visit = new boolean[11];

    static int ans = Integer.MAX_VALUE;

    static void solve(int current, int total, int max) {
        if (money < total) return;
        if (current == end) {
            ans = Math.min(ans, max);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (dist[current][i] == 0 || visit[i]) continue;
            visit[i] = true;
            solve(i, total + dist[current][i], Math.max(max, dist[current][i]));
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
            dist[b][a] = c;
        }

        solve(start, 0, 0);

        if (ans == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(ans + "");
        }
        bw.close();
        br.close();
    }
}
