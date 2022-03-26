package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14466
 * 2. 풀이
 *  - 소를 Idx로 관리하여 bfs탐색을 진행한다
 */
public class bfs_14466_cowCross {

    static int N, K, R;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static Node[] cows;
    static List<Integer>[] adj;

    static int bfs(int cowIdx) {
        boolean[][] visit = new boolean[N][N];
        int find = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(cows[cowIdx]);
        visit[cows[cowIdx].y][cows[cowIdx].x] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowIdx = now.y * N + now.x;
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(outOfRange(ny, nx) || visit[ny][nx]) continue;
                int nextIdx = ny * N + nx;
                if(!adj[nowIdx].isEmpty() && adj[nowIdx].contains(nextIdx)) continue;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx));
            }
        }

        int cnt = 0;
        for(int i = cowIdx + 1; i <= K; i++) {
            if (!visit[cows[i].y][cows[i].x]) cnt++;
        }

        return cnt;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new List[N * N];
        map = new int[N][N];
        cows = new Node[K + 1];
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = (Integer.parseInt(st.nextToken()) - 1) * N + Integer.parseInt(st.nextToken()) - 1;
            int b = (Integer.parseInt(st.nextToken()) - 1) * N + Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            map[cows[i].y][cows[i].x] = i;
        }

        int cnt = 0;
        for(int i = 1; i <= K; i++)
            cnt += bfs(i);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
