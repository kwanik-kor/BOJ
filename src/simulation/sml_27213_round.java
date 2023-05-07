package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27213
 */
public class sml_27213_round {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if (m == 1 || n == 1) {
            bw.write(m * n + "");
        } else {
            bw.write((m + n) * 2 - 4 + "");
        }

        bw.close();
        br.close();
    }

}
