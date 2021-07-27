package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/11084
 * 2. 풀이
 *  - BFS를 이용해 최종 도착지에 도달할 수 있는 최단거리와 방법의 가지수를 구하는 문제
 *  - 최단거리를 저장하는 배열과, 최단거리로 도착했을 때의 가지수를 저장하는 DP를 응용하면 됨
 */
public class bfs_11084_spyKnight {

    static final int MOD = 1000000009;
    static final int INF = 987654321;

    static int R, C;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] dist, cnt;

    static void bfs() {
        dist = new int[R + 1][C + 1];
        for(int i = 1; i <= R; i++)
            Arrays.fill(dist[i], INF);

        cnt = new int[R + 1][C + 1];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        dist[1][1] = 0;
        cnt[1][1] = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny <= 0 || nx <= 0 || R < ny || C < nx) continue;
                if(dist[now.y][now.x] + 1 < dist[ny][nx]) {
                    dist[ny][nx] = dist[now.y][now.x] + 1;
                    cnt[ny][nx] = cnt[now.y][now.x];
                    q.add(new Point(ny, nx));
                } else if(dist[now.y][now.x] + 1 == dist[ny][nx]) {
                    cnt[ny][nx] = (cnt[ny][nx] % MOD + cnt[now.y][now.x] % MOD) % MOD;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bfs();

        if(dist[R][C] == INF) {
            bw.write("None");
        } else {
            bw.write(dist[R][C] + " " + cnt[R][C]);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
