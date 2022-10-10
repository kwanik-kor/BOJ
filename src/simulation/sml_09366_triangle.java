package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9366
 * 2. 풀이
 *  - 삼각형이 성립하기 위해서는 가장 긴 변의 길이가 나머지 두 변의 길이의 합보다 커야 한다.
 */
public class sml_09366_triangle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(a, Math.max(b, c));
            if (a + b + c - max <= max) {
                bw.write(String.format("Case #%d: invalid!\n", t));
            } else {
                if (a == b && b == c) {
                    bw.write(String.format("Case #%d: equilateral\n", t));
                } else if (a == b || b == c) {
                    bw.write(String.format("Case #%d: isosceles\n", t));
                } else {
                    bw.write(String.format("Case #%d: scalene\n", t));
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
