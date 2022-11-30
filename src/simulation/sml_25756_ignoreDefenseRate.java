package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25756
 */
public class sml_25756_ignoreDefenseRate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double V = 0f;
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            V = A + V - V * A / 100;
            bw.write(V + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
