package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24446
 */
public class bfs_24446_algorithmClass {

    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];
        Arrays.fill(visit, -1);
        List<Integer>[] adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(R);

        int depth = 1;
        visit[R] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Integer now = q.poll();
                for (Integer next : adj[now]) {
                    if (visit[next] != -1) continue;
                    visit[next] = depth;
                    q.add(next);
                }
            }
            depth++;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(visit[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
