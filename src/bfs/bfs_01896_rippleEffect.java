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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1896
 * 2. 풀이
 *  - 차분하게 처리하면 됨, 구역별로 bfs를 수행하고, 수행 도중에 거리 사이에 같은 숫자가 있는지 처리해줌
 */
public class bfs_01896_rippleEffect {

    static int R, C;
    static int[] flag = {1, 2, 4, 8};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static int[][] direction;
    static boolean[][] visit;

    static boolean checkValidation(int y, int x) {
        boolean[] puzzle = new boolean[9];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visit[y][x] = true;
        puzzle[map[y][x]] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(numInRange(map[now.y][now.x], now.y, now.x)) return false;
            for(int dir = 0; dir < 4; dir++) {
                if((direction[now.y][now.x] & flag[dir]) == 0) continue;
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(outOfRange(ny, nx) || visit[ny][nx]) continue;
                if(puzzle[map[ny][nx]]) return false;

                visit[ny][nx] = true;
                puzzle[map[ny][nx]] = true;
                q.add(new Point(ny, nx));
            }
        }

        return true;
    }

    static boolean numInRange(int no, int y, int x) {
        for(int dir = 0; dir < 4; dir++) {
            int ny = y;
            int nx = x;
            for(int i = 0; i < no; i++) {
                ny += dy[dir];
                nx += dx[dir];
                if(outOfRange(ny, nx)) break;
                if(map[ny][nx] == no) return true;
            }
        }
        return false;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || R <= y || C <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[R][C];
            direction = new int[R][C];
            visit = new boolean[R][C];
            for(int i = 0; i < R; i++) {
                char[] line = br.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    map[i][j] = line[j] - '0';
                }
            }

            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    direction[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean ans = true;
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(!visit[i][j]) {
                        ans = checkValidation(i, j);
                        if(!ans) break;
                    }
                }
                if(!ans) break;
            }

            bw.write(ans ? "valid\n" : "invalid\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
