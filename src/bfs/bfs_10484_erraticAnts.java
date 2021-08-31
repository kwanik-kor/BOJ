package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_10484_erraticAnts {

    static final String DIRECTION = "NESW";
    static final int INF = 987654321;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map = new int[121][121];

    static Point end;

//    static int solve() {
//        int ret = 0;
//
//        Queue<Point> q = new LinkedList<>();
//        q.add(new Point(60, 60));
//
//        while(!q.isEmpty()) {
//            Point now = q.poll();
//            if(now.y == end.y && now.x == end.x)
//                return map[now.y][now.x];
//
//            for(int dir = 0; dir < 4; dir++) {
//                int ny = now.y + dy[dir];
//                int nx = now.x + dx[dir];
//                if(map[ny][nx] != 0) continue;
//                map[ny][nx] = map[now.y][now.x] + 1;
//                q.add(new Point(ny, nx));
//            }
//        }
//
//        return ret;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            br.readLine();
            int s = Integer.parseInt(br.readLine());

            for(int[] ints : map) {
                Arrays.fill(ints, INF);
            }

            Point node = new Point(60, 60);
            map[60][60] = 0;

            while(s-- > 0) {
                int dir = DIRECTION.indexOf(br.readLine().charAt(0));
                int ny = node.y + dy[dir];
                int nx = node.x + dx[dir];
                map[ny][nx] = 0;
                node = new Point(ny, nx);
            }
            end = node;

            bw.write(map[node.y][node.x] + "\n");
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
