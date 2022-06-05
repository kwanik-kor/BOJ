package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23037
 */
public class sml_23037_five {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = br.readLine().chars()
                .map(c -> (int) Math.pow(c - '0', 5))
                .sum();
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
