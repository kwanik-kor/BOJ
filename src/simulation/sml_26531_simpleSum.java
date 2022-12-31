package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/26531
 */
public class sml_26531_simpleSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        bw.write(Integer.parseInt(line[0]) + Integer.parseInt(line[2]) == Integer.parseInt(line[4]) ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
