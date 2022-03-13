package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24183
 */
public class math_24183_affschutsbicket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken()) * 0.229d * 0.324d * 2;
        double B = Double.parseDouble(st.nextToken()) * 0.297d * 0.42d * 2;
        double C = Double.parseDouble(st.nextToken()) * 0.21d * 0.297d;

        bw.write(String.format("%.6f", A + B+ C));
        bw.flush();
        bw.close();
        br.close();
    }
}
