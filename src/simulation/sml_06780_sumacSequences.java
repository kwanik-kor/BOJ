package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6780
 */
public class sml_06780_sumacSequences {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int length = 2;
        while (true) {
            int dif = a - b;
            if (dif < 0) break;
            a = b;
            b = dif;
            length++;
        }

        bw.write(length + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
