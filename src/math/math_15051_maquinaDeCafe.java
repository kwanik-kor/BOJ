package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15051
 */
public class math_15051_maquinaDeCafe {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        int a3 = Integer.parseInt(br.readLine());

        bw.write(Math.min(a2 * 2 + a3 * 4, Math.min(a1 * 2 + a3 * 2, a1 * 4 + a2 * 2)) + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
