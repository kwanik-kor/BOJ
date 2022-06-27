package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9493
 */
public class sml_09493_trainPlane {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double dist = Double.parseDouble(st.nextToken());
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            if (dist == 0d && A == 0d && B == 0d) break;
            double time = Math.round(Math.abs((dist / A) - (dist / B)) * 3600);
            int h = (int) time / 3600;
            int m = ((int) time % 3600) / 60;
            int s = (int) time % 60;
            bw.write(String.format("%d:%02d:%02d\n", h, m, s));

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
