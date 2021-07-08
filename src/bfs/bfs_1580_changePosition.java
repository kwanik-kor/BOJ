package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1580
 */
public class bfs_1580_changePosition {

    static int N, M;
    static int[] dy = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, 0, -1, 1, -1, 1, -1};

    static char[][] map;
    static Point A, B;
    static HashMap<Integer, Set<Integer>> visit, visitB;

    /*
        조건 1 : 한 턴에 하나 또는 두명이 움직일 수 있음
          > 움직임은 만들 수 있으나, 방문처리를 어떻게 할 것인가
     */
    static int solve(Movement m) {
        Queue<Movement> q = new LinkedList<>();
        q.add(m);
        visit.get(m.a.y * M + m.a.x).add(m.b.y * M + m.b.x);
        visitB.get(m.b.y * M + m.b.x).add(m.a.y * M + m.a.x);

        while(!q.isEmpty()) {
            Movement now = q.poll();
            if(now.a.y == B.y && now.a.x == B.x && now.b.y == A.y && now.b.x == A.x) {
                return now.n;
            }

            Point a = now.a;
            Point b = now.b;

            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {

                    // 둘 다 멈춰 있는 경우는 Pass
                    if(i == 0 && j == 0) continue;

                    int nyA = a.y + dy[i];
                    int nxA = a.x + dx[i];

                    int nyB = b.y + dy[j];
                    int nxB = b.x + dx[j];

                    Point nextA = new Point(nyA, nxA);
                    Point nextB = new Point(nyB, nxB);

                    /*
                        1. 범위를 벗어나거나 벽인 경우
                        2. 두 플레이어가 이동하고자 하는 위치가 같은 경우
                        3. 두 플레이어의 위치가 서로 교차한 경우
                     */
                    if(isOutOfRange(nyA, nxA)
                            || isOutOfRange(nyB, nxB)
                            || (nyA == nyB && nxA == nxB)
                            || (nyA == b.y && nxA == b.x && nyB == a.y && nxB == a.x))
                        continue;

                    if(visit.get(nyA * M  + nxA).contains(nyB * M + nxB) || visitB.get(nyB * M + nxB).contains(nyA * M + nxA)) continue;

                    visit.get(nyA * M + nxA).add(nyB * M + nxB);
                    visitB.get(nyB * M + nxB).add(nyA * M + nxA);
                    q.add(new Movement(nextA, nextB, now.n + 1));
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
        visit = new HashMap<>();
        visitB = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'A') {
                    A = new Point(i, j);
                    map[i][j] = '.';
                } else if(map[i][j] == 'B') {
                    B = new Point(i, j);
                    map[i][j] = '.';
                }
                if(map[i][j] == '.') {
                    visit.put(i * M + j, new HashSet<>());
                    visitB.put(i * M + j, new HashSet<>());
                }
            }
        }

        bw.write(solve(new Movement(A, B, 0)) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Movement {
        Point a;
        Point b;
        int n;
        public Movement(Point a, Point b, int n) {
            this.a = a;
            this.b = b;
            this.n = n;
        }
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
