package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15610
 */
public class math_15610_abbeyCourtyard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double metre = Double.parseDouble(br.readLine());
        bw.write(Math.sqrt(metre) * 4 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
