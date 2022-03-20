package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1064
 */
public class math_01064_parallelogram {

    static Point[] points = new Point[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        double I1 = 1987654321d;
        double I2 = 1987654321d;
        if(points[0].x != points[1].x) I1 = Math.abs(points[1].y - points[0].y) / Math.abs(points[1].x -points[0].x);
        if(points[1].x != points[2].x) I2 = Math.abs(points[2].y - points[1].y) / Math.abs(points[2].x -points[1].x);

        double ans = 0;
        if(I1 == I2) ans = -1;

        if(ans != -1) {
            double a = getDist(points[0], points[1]);
            double b = getDist(points[1], points[2]);
            double c = getDist(points[2], points[0]);

            double al = 2 * (a + b);
            double bl = 2 * (b + c);
            double cl = 2 * (c + a);

            ans = Math.max(al, Math.max(bl, cl)) - Math.min(al, Math.min(bl, cl));
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static double getDist(Point a, Point b) {
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
    }

    static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
