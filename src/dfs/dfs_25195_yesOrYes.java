package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25195
 */
public class dfs_25195_yesOrYes {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private final String EXIST = "yes";
    private final String NOT_EXIST = "Yes";
    private int N;
    private boolean ans = false;
    private ArrayList<Integer>[] adj;
    private Set<Integer> fanIdxes = new HashSet<>();

    public static void main(String[] args) throws Exception {
        dfs_25195_yesOrYes main = new dfs_25195_yesOrYes();
        bw.write(main.solve());
        bw.close();
        br.close();
    }

    String solve() throws Exception {
        initialize();
        dfs(1);
        return ans ? EXIST : NOT_EXIST;
    }

    void dfs(int node) {
        if (ans || fanIdxes.contains(node)) {
            return;
        }
        if (adj[node].size() == 0) {
            ans = true;
            return;
        }
        for (int next : adj[node]) {
            dfs(next);
        }
    }

    void initialize() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }

        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (S-- > 0) {
            fanIdxes.add(Integer.parseInt(st.nextToken()));
        }
    }
}
