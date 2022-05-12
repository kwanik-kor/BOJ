package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23811
 */
public class sml_23811_putAtSign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int length = N * 5;
        for (int i = 0; i < length; i++) {
            boolean isOdd = (i / N) % 2 == 1;
            for(int j = 0; j < length; j++) {
                if (isOdd && N <= j) break;
                bw.write("@");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
