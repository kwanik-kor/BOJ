package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15781
 */
public class sml_15781_helmetAndVest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int n = 0;
        int m = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            n = Math.max(n, Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            m = Math.max(m, Integer.parseInt(st.nextToken()));
        }

        bw.write(n + m + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
