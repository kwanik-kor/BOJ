package bfs;

import java.io.*;
import java.util.StringTokenizer;

public class bfs_02782_romanticKing {

    static int R, C, T;

    static char[][] map = new char[50][50];
    static Point king, queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            for(int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    if(map[i][j] == 'K') {
                        king = new Point(i, j);
                        map[i][j] = '.';
                    } else if(map[i][j] == 'Q') {
                        queen = new Point(i, j);
                    }
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
