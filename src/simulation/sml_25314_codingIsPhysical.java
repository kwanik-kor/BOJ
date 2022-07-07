package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25314
 */
public class sml_25314_codingIsPhysical {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine()) / 4;
        for (int i = 0; i < cnt; i++) {
            bw.write("long ");
        }
        bw.write("int");

        bw.flush();
        bw.close();
        br.close();
    }
}
