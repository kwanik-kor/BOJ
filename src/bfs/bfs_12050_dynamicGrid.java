package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/12050
 * 2. 풀이
 *  - 흠... Query 마다 구역을 탐색하게끔 풀었는데......흐으으음.....
 *    마음에 들지 않는다... 더 좋은 방법이 있을 것 같다......
 */
public class bfs_12050_dynamicGrid {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static int getAreaCnt() {
        boolean[][] visit = new boolean[R][C];
        int cnt = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    cnt++;

                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    visit[i][j] = true;

                    while(!q.isEmpty()) {
                        Point now = q.poll();
                        for(int dir = 0; dir < 4; dir++) {
                            int ny = now.y + dy[dir];
                            int nx = now.x + dx[dir];
                            if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] == 0) continue;
                            visit[ny][nx] = true;
                            q.add(new Point(ny, nx));
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
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

            bw.write(String.format("Case #%d:\n", t));
            int query = Integer.parseInt(br.readLine());
            while(query-- > 0) {
                String str = br.readLine();
                if(str.equals("Q")) {
                    bw.write(getAreaCnt() + "\n");
                } else {
                    st = new StringTokenizer(str);
                    st.nextToken();
                    int y = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    int val = Integer.parseInt(st.nextToken());
                    map[y][x] = val;
                }
            }
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
