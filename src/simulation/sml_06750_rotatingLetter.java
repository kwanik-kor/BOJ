package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6750
 */
public class sml_06750_rotatingLetter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine().replaceAll("[IOSHZXN]", "");
        bw.write(input.length() == 0 ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
