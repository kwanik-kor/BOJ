package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18856
 */
public class sml_18856_feedback {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(N + "\n");
        for (int i = 1; i <= N; i++) {
            if (i == 1) bw.write("1 ");
            else if (i == 2) bw.write("2 ");
            else if (i == N) bw.write("997");
            else bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
