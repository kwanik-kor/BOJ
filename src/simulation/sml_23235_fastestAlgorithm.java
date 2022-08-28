package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23235
 */
public class sml_23235_fastestAlgorithm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1;
        while (true) {
            if (br.readLine().equals("0")) {
                break;
            }
            bw.write(String.format("Case %d: Sorting... done!\n", n++));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
