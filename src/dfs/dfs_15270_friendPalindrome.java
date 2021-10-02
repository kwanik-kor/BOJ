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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15270
 * 2. 풀이
 *  - 깊이 우선탐색을 이용해, 만들 수 있는 쌍의 최대 개수를 찾아낸다.
 */
public class dfs_15270_friendPalindrome {

    static int N, M, ans = 0;
    static boolean[] visit;
    static List<Integer>[] edges;

    static int solve(int num, int cnt) {
        if(num == N) return cnt;
        if(visit[num]) return solve(num + 1, cnt);

        int ret = 0;
        for(Integer next : edges[num]) {
            if(visit[next]) continue;
            visit[next] = true;
            ret = Math.max(ret, solve(num + 1, cnt + 1));
            visit[next] = false;
        }
        return Math.max(ret, solve(num + 1, cnt));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[Math.min(a, b)].add(Math.max(a, b));
        }

        ans = solve(1, 0) * 2;
        bw.write((N == ans? ans : ans + 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
