package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/7299
 * 2. 풀이
 *  - 구멍 안에 또 구멍이 있을 수 있음을 왜 인지하지 못했는가!!!!!!!!!!!!!!!!!!!!!
 */
public class bfs_07299_foodCubes {

    static final int N = 102;
    static int maxX, maxY, maxZ;

    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static boolean map[][][];

    static void setVoid(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.x][start.y][start.z] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 6; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                int nz = now.z + dz[dir];
                if(nx < 0 || ny < 0 || nz < 0 || maxX <= nx || maxY <= ny || maxZ <= nz || map[nx][ny][nz]) continue;
                map[nx][ny][nz] = true;
                q.add(new Point(nx, ny, nz));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            map = new boolean[N][N][N];
            maxX = 0;
            maxY = 0;
            maxZ = 0;
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                map[x][y][z] = true;
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                maxZ = Math.max(maxZ, z);
            }

            maxX += 2;
            maxY += 2;
            maxZ += 2;

            setVoid(new Point(0, 0, 0));

            int ans = 0;
            for(int i = 0; i < maxX; i++) {
                for(int j = 0; j < maxY; j++) {
                    for(int k = 0; k < maxZ; k++) {
                        if(!map[i][j][k]) {
                            setVoid(new Point(i, j, k));
                            ans++;
                        }
                    }
                }
            }
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
