package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/8932
 */
public class math_08932_heptathlon {

    static double[] A = {9.23076, 1.84523, 56.0211, 4.99087, 0.188807, 15.9803, 0.11193};
    static double[] B = {26.7, 75, 1.5, 42.5, 210, 3.8, 254};
    static double[] C = {1.835, 1.348, 1.05, 1.81, 1.41, 1.04, 1.88};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double tot = 0d;
            for(int i = 0; i < 7; i++) {
                tot += Math.floor(A[i] * Math.pow(Math.abs(B[i] - Double.parseDouble(st.nextToken())), C[i]));
            }
            bw.write((int) tot + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
