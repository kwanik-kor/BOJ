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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21937
 * 2. 풀이
 *  - 간선의 진행방향을 뒤집어서 DFS를 처리한다.
 *   > 이렇게 할 경우, X 노드에서 출발해 방문한 모든 노드의 개수를 세면 됨
 */
public class dfs_21937_work {

    static int N, M, X;
    static boolean[] visit;
    static List<Integer>[] edges;

    static void dfs(int node) {
        visit[node] = true;
        for(Integer next : edges[node]) {
            if(visit[next]) continue;
            dfs(next);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[b].add(a);
        }

        X = Integer.parseInt(br.readLine());
        dfs(X);

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(visit[i] && i != X)
                cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
