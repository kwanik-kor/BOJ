package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1580
 * 2. 풀이
 *  - 클래스를 생성해서 Queue에 집어넣었을 때, 계속해서 메모리 초과가 났다.
 *   > 이로 인해 visit처리를 위한 고정배열을 선언해서 처리하니 통과~
 */
public class bfs_01580_changePosition {

    static int N, M;
    static int[] dy = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, 0, -1, 1, -1, 1, -1};

    static char[][] map;
    static int ay, ax, by, bx;

    /*
        조건 1 : 한 턴에 하나 또는 두명이 움직일 수 있음
          > 움직임은 만들 수 있으나, 방문처리를 어떻게 할 것인가
     */
    static int solve(Movement m) {
        boolean[][][][] visit = new boolean[N][M][N][M];
        Queue<Movement> q = new LinkedList<>();
        q.add(m);
        visit[m.ay][m.ax][m.by][m.bx] = true;

        while(!q.isEmpty()) {
            Movement now = q.poll();
            if(now.ay == by && now.ax == bx && now.by == ay && now.bx == ax) {
                return now.n;
            }

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {

                    // 둘 다 멈춰 있는 경우는 Pass
                    if(i == 0 && j == 0) continue;

                    int nyA = now.ay + dy[i];
                    int nxA = now.ax + dx[i];

                    int nyB = now.by + dy[j];
                    int nxB = now.bx + dx[j];

                    /*
                        1. 범위를 벗어나거나 벽인 경우
                        2. 두 플레이어가 이동하고자 하는 위치가 같은 경우
                        3. 두 플레이어의 위치가 서로 교차한 경우
                     */
                    if(isOutOfRange(nyA, nxA)
                            || isOutOfRange(nyB, nxB)
                            || (nyA == nyB && nxA == nxB)
                            || (nyA == now.by && nxA == now.bx && nyB == now.ay && nxB == now.ax))
                        continue;

                    if(visit[nyA][nxA][nyB][nxB]) continue;

                    visit[nyA][nxA][nyB][nxB] = true;
                    q.add(new Movement(nyA, nxA, nyB, nxB, now.n + 1));
                }
            }
        }

        return -1;
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || M <= x || map[y][x] == 'X';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'A') {
                    ay = i;
                    ax = j;
                    map[i][j] = '.';
                } else if(map[i][j] == 'B') {
                    by = i;
                    bx = j;
                    map[i][j] = '.';
                }
            }
        }

        bw.write(solve(new Movement(ay, ax, by, bx, 0)) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Movement {
        int ay;
        int ax;
        int by;
        int bx;
        int n;

        public Movement(int ay, int ax, int by, int bx, int n) {
            this.ay = ay;
            this.ax = ax;
            this.by = by;
            this.bx = bx;
            this.n = n;
        }
    }

}
