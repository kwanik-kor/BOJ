package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24294
 */
public class math_24294_bed {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long w1 = Long.parseLong(br.readLine());
        long h1 = Long.parseLong(br.readLine());
        long w2 = Long.parseLong(br.readLine());
        long h2 = Long.parseLong(br.readLine());

        bw.write(w1 + w2 + h1 * 2 + h2 * 2 + 4 + Math.abs(w2 - w1) + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
