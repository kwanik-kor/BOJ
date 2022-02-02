package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14173
 */
public class math_14173_squarePasture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Point[] points = new Point[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2; i++) {
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 2; i < 4; i++) {
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int lx = Math.min(points[0].x, points[2].x);
        int ly = Math.min(points[0].y, points[2].y);
        int rx = Math.max(points[1].x, points[3].x);
        int ry = Math.max(points[1].y, points[3].y);

        int side = Math.max(rx - lx, ry - ly);

        bw.write(side * side + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
