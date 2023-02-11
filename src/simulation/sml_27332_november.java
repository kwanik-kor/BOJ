package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27332
 */
public class sml_27332_november {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) * 7 <= 30 ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }
}
