package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23808
 */
public class sml_23808_putAtSign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int length = N * 5;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i < N * 2 && N <= j && j < length - N)
                        || (N * 3 <= i && i < N * 4 && N <= j && j < length - N)){
                    bw.write(" ");
                } else {
                    bw.write("@");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
