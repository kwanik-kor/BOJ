package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16930
 * 2. 풀이
 *  - BFS로 경로를 탐색하는 것은 크게 문제가 없다.
 *  - 단, 방문 노드를 처리함에 있어 이미 방문된 노드가 현재 이동했을 때의 cost와 동일할 경우 계속해서 방문을 이어가 보는 것이 포인트
 */
public class bfs_16930_running {

    static final int INF = 987654321;

    static int N, M, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static int[][] visit;
    static Point start, end;

    static int solve() {
        visit = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(visit[i], INF);

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return visit[now.y][now.x];

            for(int dir = 0; dir < 4; dir++) {
                for(int k = 1; k <= K; k++) {
                    int ny = now.y + dy[dir] * k;
                    int nx = now.x + dx[dir] * k;
                    if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] == '#') break;
                    if(visit[ny][nx] == INF) {
                        visit[ny][nx] = visit[now.y][now.x] + 1;
                        q.add(new Point(ny, nx));
                    } else if(visit[ny][nx] == visit[now.y][now.x] + 1) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        bw.write(solve() + "");
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
