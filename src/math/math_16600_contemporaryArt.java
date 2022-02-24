package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16600
 */
public class math_16600_contemporaryArt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double N = Double.parseDouble(br.readLine());
        double ret = 4 * Math.sqrt(N);

        bw.write(String.format("%.7f", ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
