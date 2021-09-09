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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14496
 * 2. 풀이
 *  - 최단거리 탐색 기본형
 */
public class bfs_14496_yaMinJeongEum {

    static int A, B, N, M;
    static Map<Integer, Set<Integer>> pairs = new HashMap<>();

    static int solve() {
        boolean[] visit = new boolean[N + 1];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(A, 0));
        visit[A] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.n == B)
                return now.cnt;

            for(Integer next : pairs.get(now.n)) {
                if(visit[next]) continue;
                visit[next] = true;
                q.add(new Point(next, now.cnt + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getNode(a).add(b);
            getNode(b).add(a);
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int n;
        int cnt;
        public Point(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    static Set<Integer> getNode(int n) {
        return pairs.computeIfAbsent(n, k -> new HashSet<>());
    }
}
