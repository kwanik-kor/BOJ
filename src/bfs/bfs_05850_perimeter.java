package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5850
 * 2. 풀이
 *  - 안쪽에 공백이 있는 경우 이를 건초더미의 둘레로 치지 않기 때문에,
 *    바깥 공기에서 좁혀들어오면서 건초를 만날 때마다 둘레를 +1 해주면됨.
 *  - 바보같이 N 만큼 배열 길이 잡았다가 두 번 메모리 초과남...
 *    > 문제 제대로 읽기...
 */
public class bfs_05850_perimeter {

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static Point start;

    static int findOutside() {
        int ret = 0;

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0));
        map[0][0] = -1;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || 102 <= ny || 102 <= nx || map[ny][nx] == -1) continue;

                if(map[ny][nx] == 1) {
                    ret++;
                    continue;
                }

                map[ny][nx] = -1;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[102][102];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            if(start == null) {
                start = new Point(a, b);
            }
        }

        bw.write(findOutside() + "");
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
