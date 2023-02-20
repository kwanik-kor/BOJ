package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9772
 */
public class sml_09772_quadrants {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            if (x == 0d && y == 0d) {
                bw.write("AXIS\n");
                break;
            }

            bw.write(determineQuadrants(x, y));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static String determineQuadrants(double x, double y) {
        if (x == 0d || y == 0d) {
            return "AXIS\n";
        }
        if (x > 0) {
            return y > 0 ? "Q1\n" : "Q4\n";
        } else {
            return y > 0 ? "Q2\n" : "Q3\n";
        }
    }
}
