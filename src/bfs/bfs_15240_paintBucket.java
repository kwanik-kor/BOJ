package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15240
 * 2. 풀이
 *  - 단순 BFS ~
 */
public class bfs_15240_paintBucket {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static void solve(int y, int x, int color) {
        int flag = map[y][x];

        Queue<Integer> q = new LinkedList<>();
        q.add(y * C + x);
        map[y][x] = color;

        while(!q.isEmpty()) {
            int now = q.poll();
            int nowY = now / C;
            int nowX = now % C;
            for(int dir = 0; dir < 4; dir++) {
                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != flag) continue;
                map[ny][nx] = color;
                q.add(ny * C + nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
