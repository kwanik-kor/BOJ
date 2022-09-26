package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25628
 */
public class sml_25628_makeHamburger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bread = Integer.parseInt(st.nextToken());
        int patty = Integer.parseInt(st.nextToken());
        if (bread < 2) {
            bw.write("0");
        } else {
            bw.write(String.format("%d", Math.min(bread / 2, patty)));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
