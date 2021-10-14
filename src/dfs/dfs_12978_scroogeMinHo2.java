package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12978
 * 2. 풀이
 *  - DP를 이용해서 자식 노드까지 경찰서를 건설하는 최소 개수를 구함
 *    > 현재 노드에 경찰서가 건설되어 있다면 자식 노드는 경찰서가 필요 없으며,
 *      건설되어 있지 않은 경우에는 경찰서를 짓는 경우와 짓지 않은 경우의 최솟값을 선택해야 한다.
 */
public class dfs_12978_scroogeMinHo2 {

    static final int MAX = 100001;

    static int N;
    static int[][] dp;

    static List<Integer>[] edges;

    static int setStation(int node, int parent, int police) {
        if(dp[node][police] != MAX)
            return dp[node][police];

        int cnt = 0;
        if(police == 1)
            cnt++;

        for(Integer child : edges[node]) {
            if(child != parent) {
                if(police != 1) {
                    cnt += setStation(child, node, 1);
                } else {
                    cnt += Math.min(setStation(child, node, 1), setStation(child, node, 0));
                }
            }
        }

        return dp[node][police] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        edges = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            Arrays.fill(dp[i], MAX);
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        bw.write(Math.min(setStation(1, 0, 0), setStation(1, 0, 1)) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
