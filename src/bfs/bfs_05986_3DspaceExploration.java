package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5986
 * 2. 풀이
 *  - 3차원 영역 번호 붙이기 / 3차원 이동만 잘 구현하면 문제 없음
 */
public class bfs_05986_3DspaceExploration {

    static int N;
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] map;

    static void setAesteroid(Point start, int n) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x][start.z] = n;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 6; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                int nz = now.z + dz[dir];
                if(ny < 0 || nx < 0 || nz < 0 || N <= ny || N <= nx || N <= nz || map[ny][nx][nz] != 0) continue;
                map[ny][nx][nz] = n;
                q.add(new Point(ny, nx, nz));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                char[] arr = br.readLine().toCharArray();
                for(int k = 0; k < N; k++) {
                    if(arr[k] == '.')
                        map[j][k][i] = -1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(map[i][j][k] == 0)
                        setAesteroid(new Point(i, j, k), ++ans);
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int z;
        public Point(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}
