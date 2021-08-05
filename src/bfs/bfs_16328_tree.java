package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16328
 * 2. 풀이
 *  1) Floyd + Combination 으로 풀었을 때 시간초과가 뜸
 *  2) 이분 탐색으로 길이를 조정하며, 조건에 만족하는지 검사했을 때 통과함
 */
public class bfs_16328_tree {

    static int N, M;
    static int[] type;
    static int[] visit;
    static Map<Integer, Set<Integer>> map;

    static int dfs(int u, int pre, int k, int dfn) {
        int ret = type[u];
        if(dfn == k) return ret;
        for(int next : map.get(u)) {
            if(next == pre || visit[next] == 0) continue;
            ret += dfs(next, u, k, dfn + 1);
        }
        return ret;
    }

    static boolean check(int k) {
        visit = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int now = q.poll();
            visit[now] = 1;
            if(dfs(now, 0, k, 0) >= M) return true;
            for(int next : map.get(now)) {
                if(visit[next] != 0) continue;
                q.add(next);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        type = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
            map.put(i, new HashSet<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int l = 0;
        int r = N;
        while(l < r) {
            int mid = (l + r) >> 1;
            if(check(mid))
                r = mid;
            else
                l = mid + 1;
        }

        bw.write(r + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
