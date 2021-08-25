package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13265
 */
public class bfs_13265_coloring {

    static int N, M;
    static int[] color;
    static boolean result = true;

    static Map<Integer, Set<Integer>> edges = new HashMap<>();

    static void solve(int start) {
        for(Integer next : edges.get(start)) {
            if(color[next] == 0) {
                color[next] = color[start] * -1;
                solve(next);
            } else if(color[next] == color[start]) {
                result = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = true;

            color = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                edges.put(i, new HashSet<>());
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
                edges.get(b).add(a);
            }

            for(int i = 1; i <= N; i++) {
                if(color[i] == 0) {
                    color[i] = 1;
                    solve(i);
                }
            }

            bw.write(result? "possible\n" : "impossible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
