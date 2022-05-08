package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23795
 */
public class sml_23795_gambling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            cnt += n;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
