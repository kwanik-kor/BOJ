package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24751
 */
public class sml_24751_betting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double option = Double.parseDouble(br.readLine());
        bw.write(String.format("%.10f\n%.10f", 100 / option, 100 / (100 - option)));
        bw.flush();
        bw.close();
        br.close();
    }
}
