package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25516
 */
public class bfs_25516_apple {

    static int N, K;
    static Set<Integer>[] adj;
    static Boolean[] apple;

    static int solve() {
        boolean[] visit = new boolean[N];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visit[0] = true;

        int cnt = apple[0] ? 1 : 0;
        int dist = 1;

        while (!q.isEmpty()) {
            if (dist > K) break;

            int size = q.size();

            while (size-- > 0) {
                Integer now = q.poll();
                for (Integer next : adj[now]) {
                    if (visit[next]) continue;
                    visit[next] = true;
                    cnt += apple[next] ? 1 : 0;
                    q.add(next);
                }
            }

            dist++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new Set[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        apple = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::valueOf)
                        .mapToObj(a -> a == 1)
                        .toArray(Boolean[]::new);

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
