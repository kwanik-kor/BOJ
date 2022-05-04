package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23803
 */
public class sml_23803_putAtSign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N * 4; i++) {
            for(int j = 0; j < N; j++) {
                bw.write("@");
            }
            bw.write("\n");
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0, n = N * 5; j < n; j++) {
                bw.write("@");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
