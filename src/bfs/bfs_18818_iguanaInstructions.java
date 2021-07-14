package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18818
 * 2. 풀이
 *  - 방향전환을 최소로 해서 도착하는 경로를 찾는 문제다.
 *  - 처음에는 방문 노드에 대한 처리를 단순히 boolean 배열로 처리를 했으나,
 *    반례가 있었다.
 *
 *  ex)
 *  4
 *  ....
 *  .##.
 *  ....
 *  ..#.
 *
 *  - 위 반례의 경우, 최단거리 루트는 두개지만, (2, 0)을 거쳐서 가는 경로가
 *    Queue에 먼저 들어감에 따라, (0, 3)을 거치는 경로가 최종 목적지에 도달하지 못하는 문제가 있었다.
 *  - 그래서 2차원 int 배열로 방문 처리를 하였는데, 이동하고자 하는 노드의 방향 전환 횟수가
 *    기존 방향 전환 횟수보다 적다면 지나갈 수 있게 처리하였다.
 */
public class bfs_18818_iguanaInstructions {

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static int[][] visit;

    static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        visit[0][0] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y;
                int nx = now.x;
                while(true) {
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] == '#' || visit[ny][nx] < now.n + 1) break;
                    visit[ny][nx] = now.n + 1;
                    q.add(new Point(ny, nx, now.n + 1));
                }
            }
        }

        return visit[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new int[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(visit[i], 987654321);
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
