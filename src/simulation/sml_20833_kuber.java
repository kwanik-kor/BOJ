package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/20833
 */
public class sml_20833_kuber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()) + 1;

        int tot = 0;
        while (N-- > 0) {
            tot += N * N * N;
        }

        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
