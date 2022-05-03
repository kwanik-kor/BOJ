package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23794
 */
public class sml_23794_putAtSign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                if (i == 0 || i == N + 1 || j == 0 || j == N + 1)
                    bw.write("@");
                else
                    bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
