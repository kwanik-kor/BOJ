package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24623
 */
public class math_24623_Изгороди {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double n = Double.parseDouble(br.readLine());
        double a = Double.parseDouble(br.readLine());
        double result = Math.round((180d - a) / 2 + a / 2);
        bw.write(String.format("%.0f", result));
        bw.flush();
        bw.close();
        br.close();
    }
}
