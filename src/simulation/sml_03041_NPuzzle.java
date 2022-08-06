package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3041
 */
public class sml_03041_NPuzzle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Point> points = IntStream.rangeClosed(0, 15)
                        .mapToObj(i -> new Point(i / 4, i % 4))
                        .collect(Collectors.toList());

        int dist = 0;
        for (int i = 0; i < 4; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < 4; j++) {
                if (arr[j] == '.') continue;
                int idx = arr[j] - 'A';
                dist += points.get(idx).getDist(i, j);
            }
        }

        bw.write(dist + "");
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

        public int getDist(int y, int x) {
            return Math.abs(this.y - y) + Math.abs(this.x - x);
        }
    }
}
