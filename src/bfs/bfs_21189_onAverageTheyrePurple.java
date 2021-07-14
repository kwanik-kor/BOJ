package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21189
 * 2. 풀이
 *  - Bob은 색깔 변화를 최소한으로 겪는 경로를 무조건 선택할 것이고,
 *    Alice 는 어떻게든 이 경로에서 색깔 변화를 최대로 하게 만들고 싶어함
 *  - 1번 노드에서 N번 노드로 가는 최소 경로에서 1을 빼주면 정답쓰
 *    > 1 - M, M - N으로 가는 경로만 있다고 가정했을 때, 
 *      Alice는 무조건 두 경로를 다르게 색칠해 색깔 변화를 겪게 만들 것임
 *    >> 즉, Bob은 최대한 짧은 경로로 N까지 이동을 해야만 하고
 *       이 때 길이가 k라면 Alice는 어떻게든 k - 1로 만들어 버림
 *
 *  하.. 양방향 노드 실수로 안해서 정답률 100%를 깨버렸다..... 가슴이 아프다........
 */
public class bfs_21189_onAverageTheyrePurple {

    static int N, M;
    static boolean[] visit;

    static Map<Integer, Set<Integer>> map;

    static int solve() {
        visit = new boolean[N + 1];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visit[1] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.n == N)
                return now.dist;

            for(Integer next : map.get(now.n)) {
                if(visit[next]) continue;
                visit[next] = true;
                q.add(new Point(next, now.dist + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for(int i = 1; i <= N; i++)
            map.put(i, new HashSet<>());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int ans = solve();
        bw.write((ans == 0? 0 : ans - 1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int n;
        int dist;
        public Point(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
}
