package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/7581
 */
public class math_07581_cuboid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0 && l == 0 && v == 0) break;
            if (w == 0) {
                w = v / h / l;
            } else if (h == 0) {
                h = v / w / l;
            } else if (l == 0) {
                l = v / w / h;
            } else {
                v = w * h * l;
            }
            bw.write(String.format("%d %d %d %d\n", w, h, l, v));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
