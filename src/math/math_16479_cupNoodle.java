package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16479
 */
public class math_16479_cupNoodle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float k = Float.parseFloat(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        float d1 = Float.parseFloat(st.nextToken());
        float d2 = Float.parseFloat(st.nextToken());
        if (d1 == d2) {
            bw.write(String.format("%.0f", k * k));
        } else {
            float temp = (d1 - d2) / 2f;
            bw.write(String.format("%.6f", k * k - temp * temp));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
