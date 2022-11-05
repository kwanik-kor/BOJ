package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14682
 */
public class sml_14682_shiftySum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int tot = N;
        while (k-- > 0) {
            N *= 10;
            tot += N;
        }
        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
