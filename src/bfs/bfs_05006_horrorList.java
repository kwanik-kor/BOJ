package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5006
 * 2. 풀이
 *  - 푸는 중
 */
public class bfs_05006_horrorList {

    static final int INF = 987654321;
    static int N, H, L;
    static int[] movies;
    static Map<Integer, Set<Integer>> edges = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        movies = new int[N];
        Arrays.fill(movies, INF);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < H; i++)
            movies[Integer.parseInt(st.nextToken())] = 0;

        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new HashSet<>());
    }
}
