package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17391
 * 2. 풀이
 *  - 기본적인 BFS 문제이며, 도착한 노드에서 이동할 수 있는 거리만 추가적으로 잘 계산해주면 됨
 */
public class bfs_17391_infinityBooster {

    static int N, M;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static int[][] map;

    static int solve() {
        boolean[][] visit = new boolean[N][M];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == N - 1 && now.x == M - 1)
                return now.n;

            for(int dir = 0; dir < 2; dir++) {
                for(int dist = 1; dist <= map[now.y][now.x]; dist++) {
                    int ny = now.y + dy[dir] * dist;
                    int nx = now.x + dx[dir] * dist;
                    if(ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx, now.n + 1));
                }
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

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int n;
        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}
