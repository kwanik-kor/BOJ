package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5033
 * 2. 풀이
 *  - 친구 관계를 그룹별로 분할하고, 분할된 그룹의 돈을 빌리고 빌려준 금액의 합계가 0원인지 판단한다.
 *   - BFS를 이용한 Group 탐색이 주된 문제의 요점
 */
public class bfs_5033_moneyMatters {

    static int N, M;
    static int[] money;
    static boolean[] visit;
    static Set<Integer>[] adj;

    static boolean checkGroup(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        int sum = money[idx];
        visit[idx] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : adj[now]) {
                if (visit[next]) continue;
                visit[next] = true;
                sum += money[next];
                q.add(next);
            }
        }

        return sum == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];
        visit = new boolean[N];
        adj = new Set[N];
        for(int i = 0 ; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            adj[i] = new HashSet<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        boolean result = true;
        for(int i = 0; i < N; i++) {
            if(!visit[i])
                result = checkGroup(i);
            if(!result) break;
        }

        bw.write(result? "POSSIBLE" : "IMPOSSIBLE");
        bw.flush();
        bw.close();
        br.close();
    }
}
