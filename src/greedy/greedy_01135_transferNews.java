package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1135
 */
public class greedy_01135_transferNews {

    static List<Integer>[] adj;

    static int solve(int node) {
        if (adj[node].isEmpty()) {
            return 0;
        }

        int length = adj[node].size();
        Integer[] subMemo = new Integer[length];
        for (int i = 0; i < length; i++) {
            subMemo[i] = solve(adj[node].get(i));
        }

        Arrays.sort(subMemo, Collections.reverseOrder());

        int ret = 0;
        for (int i = 0; i < length; i++) {
            ret = Math.max(ret, subMemo[i] + (i + 1));
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1) continue;
            adj[parentNode].add(i);
        }

        bw.write(solve(0) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
