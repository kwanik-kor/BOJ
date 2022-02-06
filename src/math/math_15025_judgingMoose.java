package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15025
 */
public class math_15025_judgingMoose {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a == 0 && b == 0) {
            bw.write("Not a moose");
        } else if (a != b) {
            bw.write(String.format("Odd %d", Math.max(a, b) * 2));
        } else {
            bw.write(String.format("Even %d", a * 2));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
