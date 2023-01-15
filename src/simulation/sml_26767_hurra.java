package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26767
 */
public class sml_26767_hurra {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                bw.write("Wiwat!\n");
            } else if (i % 7 == 0) {
                bw.write("Hurra!\n");
            } else if (i % 11 == 0) {
                bw.write("Super!\n");
            } else {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
