package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15900
 * 2. 풀이
 *  - 두 명이 순차적으로 리프노드의 게임말을 루트노드까지 옮기는 작업을 수행한다.
 *   - 먼저 시작한 성원이가 최종적인 승자가 되기 위해서는, 루트노드로부터 각 리프노드까지의 거리를 모두 더했을때
 *     홀수가 되어야만 성원이가 마지막 게임말을 루트노드로 옮길 수 있게 된다.
 *  - 즉, 모든 루트노드 -> 리프노드 거리 합의 홀/짝 여부를 판단하면 된다.
 */
public class dfs_15900_escapeTree {

    static int N;
    static int tot = 0;

    static boolean[] visit;
    static List<Integer> adj[];

    static void dfs(int idx, int dist) {
        visit[idx] = true;

        int leaf = 0;
        for(Integer next : adj[idx]) {
            if(visit[next]) continue;
            leaf++;
            dfs(next, dist + 1);
        }

        if(leaf == 0)
            tot += dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        adj = new List[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1, 0);

        bw.write(tot % 2 == 0? "No" : "Yes");
        bw.flush();
        bw.close();
        br.close();
    }
}
