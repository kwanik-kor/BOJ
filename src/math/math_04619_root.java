package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4619
 */
public class math_04619_root {

    static double B, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            B = Double.parseDouble(st.nextToken());
            N = Double.parseDouble(st.nextToken());
            if(B == 0d && N == 0d) break;
            double dist = 1000000;
            double ans = 1d;
            while(true) {
                double tempDist = Math.abs(B - Math.pow(ans, N));
                if(tempDist <= dist) dist = tempDist;
                else {
                    ans--;
                    break;
                }
                ans++;
            }
            bw.write(String.format("%d\n", (int) ans));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
