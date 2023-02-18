package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/20304
 */
public class bfs_20304_makePassword {

    static int N, M;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visit = new int[N + 1];
        Arrays.fill(visit, -1);

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            q.add(n);
            visit[n] = 0;
        }

        bw.write(bfs(q) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Queue<Integer> q) {
        int ans = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 20; i++) {
                int next = now ^ (1 << i);
                if (N < next || visit[next] != -1) continue;
                visit[next] = visit[now] + 1;
                q.add(next);
                ans = Math.max(ans, visit[next]);
            }
        }

        return ans;
    }
}
