package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23080
 */
public class sml_23080_scytalePassword {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        for (int i = 0, n = line.length(); i < n; i += N) {
            sb.append(line.charAt(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
