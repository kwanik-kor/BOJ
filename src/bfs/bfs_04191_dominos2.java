package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4191
 * 2. 풀이
 *  - m과 l이 0일 수도 있음!!!!!!!
 */
public class bfs_04191_dominos2 {

    static int N, M, L;
    static boolean[] visit;
    static Map<Integer, Set<Integer>> edges;

    static int getCount(int start) {
        int ret = visit[start]? 0 : 1;
        if(ret == 0)
            return 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : edges.getOrDefault(now, new HashSet<>())) {
                if(visit[next]) continue;
                visit[next] = true;
                ret++;
                q.add(next);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            edges = new HashMap<>();
            visit = new boolean[N + 1];
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                getNode(a).add(b);
            }

            int ans = 0;
            for(int l = 0; l < L; l++) {
                ans += getCount(Integer.parseInt(br.readLine()));
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new HashSet<>());
    }
}
