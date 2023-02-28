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

        if (checkInclination(points[0], points[1], points[2])) {
            bw.write("-1.0");
        } else {
            double abL = getDist(points[0], points[1]);
            double bcL = getDist(points[1], points[2]);
            double caL = getDist(points[2], points[0]);

            double temp1 = (abL + bcL) * 2;
            double temp2 = (bcL + caL) * 2;
            double temp3 = (caL + abL) * 2;

            double ans = Math.max(temp1, Math.max(temp2, temp3)) - Math.min(temp1, Math.min(temp2, temp3));
            bw.write(String.format("%.16f", ans));
        }

        bw.close();
        br.close();
    }

    static double getDist(Point a, Point b) {
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
    }

    static boolean checkInclination(Point a, Point b, Point c) {
        return (b.y - a.y) * (c.x - b.x) == (b.x - a.x) * (c.y - b.y);
    }

    static class Point {
        double x, y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
